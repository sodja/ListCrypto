package com.codesodja.crypto.framework.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Contract(
    val contract: String,
    val platform: String,
    val type: String
)