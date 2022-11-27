package com.example.jetpackpractice.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackpractice.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val model: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navCtrl = rememberNavController()
            NavHost(navController = navCtrl, startDestination = "TopPage") {
                composable(route = "TopPage") {
                    TopPage(navCtrl, model)
                }
                composable(route = "SettingPage") {
                    SettingPage(navCtrl)
                }
            }
        }
    }
}
