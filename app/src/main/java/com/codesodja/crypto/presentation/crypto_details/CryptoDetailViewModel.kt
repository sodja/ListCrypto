package com.codesodja.crypto.presentation.crypto_details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codesodja.core.use_case.GetCryptoMoneyDetailUseCase
import com.codesodja.core.utils.Resource
import com.codesodja.crypto.framework.utils.Constant
import com.codesodja.crypto.framework.utils.Constant.PARAM_CRYPTO_ID
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CryptoDetailViewModel @Inject constructor(
    private val getCryptoMoneyDetailUseCase: GetCryptoMoneyDetailUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel(){

  private val _state = mutableStateOf(CryptoDetailState())
    val state = _state

    init {
        savedStateHandle.get<String>(PARAM_CRYPTO_ID)?.let { cryptoId->
            getCryptoMoney(cryptoId)
        }
    }

    private fun getCryptoMoney(id: String){
        viewModelScope.launch {
            getCryptoMoneyDetailUseCase(id).onEach{ result ->
            when(result){
                is Resource.Success->{
                    _state.value = CryptoDetailState(cryptoDetail = result.data)
                }
                is Resource.Error->{
                    _state.value = CryptoDetailState(error = result.message?: "An unexpected error occured")
                }
                is Resource.Loading->{
                    _state.value = CryptoDetailState(isLoading = true)
                }
            }
            }.launchIn(viewModelScope)
        }
    }
}