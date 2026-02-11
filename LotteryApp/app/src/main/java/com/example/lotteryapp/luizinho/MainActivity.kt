package com.example.lotteryapp.luizinho

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lotteryapp.luizinho.ui.screens.NumberAmountScreen
import com.example.lotteryapp.luizinho.ui.screens.ResultScreen
import com.example.lotteryapp.luizinho.ui.theme.LotteryAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LotteryAppTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "input"){

                    composable("input"){
                        NumberAmountScreen(navController)
                    }

                    composable("result"){
                        ResultScreen()
                    }

                }
            }
        }
    }
}

