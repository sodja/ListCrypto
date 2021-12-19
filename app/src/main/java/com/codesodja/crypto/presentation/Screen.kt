package com.codesodja.crypto.presentation

sealed class Screen(val route: String){
    object CryptoListScreen: Screen("crypto_list_screen")
    object CryptoDetailScreen: Screen("crypto_detail_screen")
}
