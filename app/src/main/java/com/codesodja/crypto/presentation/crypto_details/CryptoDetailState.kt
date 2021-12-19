package com.codesodja.crypto.presentation.crypto_details

import com.codesodja.core.domain.CryptoDetail

data class CryptoDetailState(
    val cryptoDetail: CryptoDetail? = null,
    val isLoading: Boolean = false,
    val error: String = ""
)
