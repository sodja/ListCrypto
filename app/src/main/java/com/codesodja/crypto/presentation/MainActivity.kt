package com.codesodja.crypto.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.codesodja.crypto.presentation.crypto_details.CryptoDetailScreen
import com.codesodja.crypto.presentation.crypto_list.CryptoListScreen
import com.codesodja.crypto.presentation.ui.theme.CryptoTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.CryptoListScreen.route){
                        composable(route = Screen.CryptoListScreen.route){
                            CryptoListScreen(navController)
                        }
                        composable(route = Screen.CryptoDetailScreen.route + "/{id}"){
                            CryptoDetailScreen()
                        }
                    }
                }
            }
        }
    }
}
