package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.widgets.InstagramProfile

class MainActivity : ComponentActivity() {
    @ExperimentalComposeUiApi
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val painter: Painter = painterResource(id = R.drawable.image)
            val title = "title"
            val contentDescription = "content description"
//            Box(
//                modifier = Modifier.fillMaxSize()
//
//            ) {
//                Column {
//                    TopAppBar(
//                        title = { Text("My App") },
//                        actions = {
//                            IconButton(onClick = { /* Do something */ }) {
//                                Icon(Icons.Default.Search, contentDescription = "Search")
//                            }
//                        },
//                    )
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
//                    Box(
//                        contentAlignment = Alignment.Center,
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .background(Color(0xff101010))
//                    ) {
//                        DragableMusicKnobWidget(modifier = Modifier)
//                    }
//                }
//            }
            MyApplicationTheme {
//            MeditationPage()
            InstagramProfile()
            }
        }
    }
}
