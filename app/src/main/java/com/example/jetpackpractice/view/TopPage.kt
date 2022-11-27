package com.example.jetpackpractice.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jetpackpractice.viewmodel.MainViewModel

@Preview(name = "TopPage")
@Composable
fun TopPage(navCtrl: NavController? = null, model: MainViewModel? = null) {
    model?.let {
        MaterialTheme {
            Column {
                TopBar(
                    addFunc = { it.add() },
                    subFunc = { it.sub() },
                    goSettingPageFunc = { navCtrl?.navigate("SettingPage") },
                )
                Figure(it.counter.observeAsState())
            }
        }
    }
}

@Preview(name = "TopBar")
@Composable
private fun TopBar(
    addFunc: () -> Unit = {},
    subFunc: () -> Unit = {},
    goSettingPageFunc: () -> Unit = {},
) {
    val barHeight = 42.dp

    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Btn(addFunc, "+", barHeight)
        Btn(subFunc, "-", barHeight)
        Btn(goSettingPageFunc, "*", barHeight)
    }
}

@Composable
private fun Btn(
    onClick: () -> Unit,
    text: String,
    height: Dp,
) {
    Button(
        onClick,
        Modifier
            .size(height)
    ) {
        Text(
            text,
            Modifier
                .height(height),
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
        )
    }
}

@Preview(name = "Figure")
@Composable
private fun Figure(figureState: State<Int?>? = null) {
    figureState?.value?.let {
        Box(
            Modifier
                .size(32.dp)
        ) {
            Text(
                it.toString(),
                fontSize = 24.sp,
            )
        }
    }
}

