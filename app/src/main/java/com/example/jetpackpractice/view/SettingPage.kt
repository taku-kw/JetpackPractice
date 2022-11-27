package com.example.jetpackpractice.view

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Preview(name = "SettingPage")
@Composable
fun SettingPage(navCtrl: NavController? = null) {
    MaterialTheme {
        TextButton({ navCtrl?.navigateUp() }) {
            Text("Back")
        }
    }
}
