package com.codesodja.crypto.presentation.crypto_list

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codesodja.core.use_case.GetCryptoMoneyUseCase
import com.codesodja.core.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CryptoListViewModel @Inject constructor(
    private val getCryptoMoneyUseCase: GetCryptoMoneyUseCase
): ViewModel(){

  private val _state = mutableStateOf(CryptoListState())
    val state = _state

    init {
        getCryptoMoneys()
    }

    private fun getCryptoMoneys(){
        viewModelScope.launch {
            getCryptoMoneyUseCase().onEach{ result ->
            when(result){
                is Resource.Success->{
                    _state.value = CryptoListState(cryptoListItem = result.data?: emptyList())
                }
                is Resource.Error->{
                    _state.value = CryptoListState(error = result.message?: "An unexpected error occured")
                }
                is Resource.Loading->{
                    _state.value = CryptoListState(isLoading = true)
                }
            }
            }.launchIn(viewModelScope)
        }
    }
}