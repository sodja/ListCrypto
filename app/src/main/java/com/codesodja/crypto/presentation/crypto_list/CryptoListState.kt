package com.codesodja.crypto.presentation.crypto_list

import com.codesodja.core.domain.Crypto

data class CryptoListState(
    val cryptoListItem: List<Crypto> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = ""
)
