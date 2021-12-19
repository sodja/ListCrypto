package com.codesodja.core.use_case

import com.codesodja.core.data.CryptoRepository
import com.codesodja.core.domain.Crypto
import com.codesodja.core.utils.Resource
import kotlinx.coroutines.flow.Flow

class GetCryptoMoneyUseCase(
    private val repository: CryptoRepository
) {
    operator fun invoke(): Flow<Resource<List<Crypto>>> {
        return repository.getCryptoMoneys()
    }
}