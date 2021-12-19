package com.codesodja.core.use_case

import com.codesodja.core.data.CryptoRepository
import com.codesodja.core.domain.CryptoDetail
import com.codesodja.core.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetCryptoMoneyDetailUseCase(
    private val repository: CryptoRepository
) {
    suspend operator fun invoke(id: String): Flow<Resource<CryptoDetail>>{
        if(id.isBlank()){
            return flow {  }
        }
        return repository.getCryptoMoneyById(id)
    }
}