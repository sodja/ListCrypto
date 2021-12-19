package com.codesodja.core.domain

data class CryptoDetail(
    val cryptoId: String,
    val name:String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>
)
