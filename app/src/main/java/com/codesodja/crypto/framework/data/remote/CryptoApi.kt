package com.codesodja.crypto.framework.data.remote

import com.codesodja.crypto.framework.data.remote.dto.CryptoDetailDto
import com.codesodja.crypto.framework.data.remote.dto.CryptoDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CryptoApi {

    @GET("/v1/coins")
    suspend fun getCryptoMoneys(): List<CryptoDto>

    @GET("/v1/coins/{id}")
    suspend fun getCryptoMoneyById(@Path("id") id: String): CryptoDetailDto
}