package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.example.myapplication.widgets.DragableMusicKnobWidget

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val painter: Painter = painterResource(id = R.drawable.image)
            val title = "title"
            val contentDescription = "content description"
            Box(
                modifier = Modifier.fillMaxSize()

            ) {
                Column {
                    TopAppBar(
                        title = { Text("My App") },
                        actions = {
                            IconButton(onClick = { /* Do something */ }) {
                                Icon(Icons.Default.Search, contentDescription = "Search")
                            }
                        },
                    )
//                ImageCard(
//                    LocalContext.current,
//                    painter = painter,
//                    title = title,
//                    descrription = contentDescription,
//                )
//                TextWidget(title = "Jetpack Compose")
//                ColorBox(
//                    Modifier
//                        .fillMaxSize()
//                        .shadow(5.dp))
//                MTextField()
//                ComposeList(Modifier.padding(16.dp))
//                    SimpleAnimatedBox(Modifier)
//                    Box(
//                        contentAlignment = Alignment.Center,
//                        modifier = Modifier.fillMaxSize()
//                    ){
//                        CircleProgressBar(percentage = 0.8f, number =100)
//                    }
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color(0xff101010))
                    ) {
                        DragableMusicKnobWidget(modifier = Modifier)
                    }
                }
            }
        }
    }
}
