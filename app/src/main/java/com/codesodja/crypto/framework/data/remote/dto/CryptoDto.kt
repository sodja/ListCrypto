package com.codesodja.crypto.framework.data.remote.dto

import com.codesodja.core.domain.Crypto
import com.google.gson.annotations.SerializedName


data class CryptoDto(
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
){
    fun toCrytpo(): Crypto = Crypto(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol
    )
}