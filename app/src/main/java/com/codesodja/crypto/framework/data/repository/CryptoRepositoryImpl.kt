package com.codesodja.crypto.framework.data.repository

import com.codesodja.core.data.CryptoRepository
import com.codesodja.core.domain.Crypto
import com.codesodja.core.domain.CryptoDetail
import com.codesodja.core.utils.Resource
import com.codesodja.crypto.framework.data.remote.CryptoApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CryptoRepositoryImpl @Inject constructor(
    private val api: CryptoApi
): CryptoRepository {
    override fun getCryptoMoneys(): Flow<Resource<List<Crypto>>> = flow{
        try {
            emit(Resource.Loading())
            val remoteCrypto = api.getCryptoMoneys().map { it.toCrytpo() }
            emit(Resource.Success(remoteCrypto))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage?:"Oops, something went wrong", data = null))
        }catch (e: IOException){
            emit(Resource.Error("Couldn't reach server, check your internet connection", data = null))
        }
    } as Flow<Resource<List<Crypto>>>

    override fun getCryptoMoneyById(id: String): Flow<Resource<CryptoDetail>> = flow{
        try {
            emit(Resource.Loading())
            val remoteCryptoDetail = api.getCryptoMoneyById(id).toCryptoDetail()
            emit(Resource.Success(remoteCryptoDetail))
        }catch (e: HttpException){
            emit(Resource.Error("Oops, something went wrong", data = null))

        }catch (e: IOException){
            emit(Resource.Error("Couldn't reach server, check your internet connection", data = null))
        }
    } as Flow<Resource<CryptoDetail>>

}