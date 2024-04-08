package com.example.myapplication.widgets

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun SimpleAnimatedBox(modifier: Modifier) {
    var boxSizeState by remember {
        mutableStateOf(200.dp)
    }

    val animatedSize by animateDpAsState(
        targetValue = boxSizeState, tween(
            durationMillis = 1000,
        )
    )

    val infinitTransition = rememberInfiniteTransition()
    val color by infinitTransition.animateColor(
        initialValue = Color.Red, targetValue = Color.Green,
        animationSpec = infiniteRepeatable(
            tween(durationMillis = 2000), repeatMode = RepeatMode.Reverse,
        ),
    )
    Box(
        modifier = modifier
            .size(animatedSize)
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Button(
                modifier = modifier.weight(1f),
                onClick = { boxSizeState += 50.dp },
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(text = "icrease size", overflow = TextOverflow.Ellipsis, maxLines = 1)
            }
            Spacer(modifier = modifier.width(4.dp))
            Button(
                modifier = modifier.weight(1f),
                onClick = { boxSizeState = 200.dp },
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(text = "reset size", overflow = TextOverflow.Ellipsis, maxLines = 1)
            }
        }
    }
}