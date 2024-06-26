package com.example.myapplication.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlin.random.Random


@Composable
fun ColorBox(modifire: Modifier = Modifier) {
    val color = remember {
        mutableStateOf(Color.Yellow)
    }

    Column {
        BtnUpdateColorBox(
            Modifier
                .weight(1f)
                .fillMaxSize()
        ) {
            color.value = it
        }
        Box(
            modifire
                .weight(1f)
                .fillMaxSize()
                .background(color = color.value)
        )
    }

}

@Composable
fun BtnUpdateColorBox(
    modifire: Modifier = Modifier,
    onColorUpdatelistener: (Color) -> Unit
) {
    Box(
        modifire
            .background(Color.Red)
            .clickable {
                onColorUpdatelistener(
                    Color(
                        Random.nextInt(),
                        Random.nextInt(),
                        Random.nextInt(),
                    )
                )
            })
}