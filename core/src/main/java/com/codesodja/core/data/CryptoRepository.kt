package com.codesodja.core.data

import com.codesodja.core.domain.Crypto
import com.codesodja.core.domain.CryptoDetail
import com.codesodja.core.utils.Resource
import kotlinx.coroutines.flow.Flow

interface CryptoRepository {

    fun getCryptoMoneys(): Flow<Resource<List<Crypto>>>

    fun getCryptoMoneyById(id: String): Flow<Resource<CryptoDetail>>
}