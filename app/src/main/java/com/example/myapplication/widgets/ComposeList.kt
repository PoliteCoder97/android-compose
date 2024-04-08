package com.example.myapplication.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ComposeList(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        itemsIndexed(
            listOf(
                "Ali",
                "Mohammad",
                "Esmaeel",
                "Hossain",
                "Hossain",
                "Hossain",
                "Hossain",
                "Hossain",
                "Hossain",
                "Hossain",
                "Hossain",
                "Hossain",
                "Hossain",
                "Hossain",
                "Hossain",
                "Hossain",
                "Hossain",
                "Hossain",
            )
        ) { index, item ->
            Text(
                text = item,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp, vertical = 4.dp),
                textAlign = TextAlign.Center,
                fontSize = 16.sp
            )
        }
    }
}