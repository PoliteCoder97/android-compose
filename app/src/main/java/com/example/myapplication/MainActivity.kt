package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.widgets.ImageCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val painter: Painter = painterResource(id = R.drawable.image)
            val title = "title"
            val contentDescription = "content description"
            Box(
                modifier = Modifier
                    .width(200.dp)
                    .fillMaxHeight(.4f)
                    .padding(16.dp)
            ) {
                ImageCard(
                    LocalContext.current,
                    painter = painter,
                    title = title,
                    descrription = contentDescription,
                )
            }
        }
    }
}
