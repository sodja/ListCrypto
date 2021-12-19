package com.codesodja.crypto.framework.di

import com.codesodja.core.data.CryptoRepository
import com.codesodja.core.use_case.GetCryptoMoneyDetailUseCase
import com.codesodja.core.use_case.GetCryptoMoneyUseCase
import com.codesodja.crypto.framework.data.remote.CryptoApi
import com.codesodja.crypto.framework.data.repository.CryptoRepositoryImpl
import com.codesodja.crypto.framework.utils.Constant.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import kotlin.jvm.java as java

@Module
@InstallIn(SingletonComponent::class)
object CryptoModule {

    @Provides
    @Singleton
    fun provideGetCryptoMoneyUseCase(repository: CryptoRepository): GetCryptoMoneyUseCase =
        GetCryptoMoneyUseCase(repository = repository)


    @Provides
    @Singleton
    fun provideGetCryptoMoneyDetailUseCase(repository: CryptoRepository): GetCryptoMoneyDetailUseCase =
         GetCryptoMoneyDetailUseCase(repository = repository)


    @Provides
    @Singleton
    fun provideCryptoApi(): CryptoApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CryptoApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCryptoRepository(api: CryptoApi): CryptoRepository {
        return CryptoRepositoryImpl(api)
    }
}