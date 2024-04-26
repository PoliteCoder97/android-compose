package com.example.myapplication.widgets

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.meditation.models.SelectableItem

@Composable
fun MultySelectLazyColumn() {
    var items by remember {
        mutableStateOf(
            listOf<SelectableItem>(
                SelectableItem(title = "item 1"),
                SelectableItem(title = "item 2"),
                SelectableItem(title = "item 3"),
                SelectableItem(title = "item 4"),
                SelectableItem(title = "item 5"),
                SelectableItem(title = "item 6"),
                SelectableItem(title = "item 7"),
                SelectableItem(title = "item 8"),
                SelectableItem(title = "item 9"),
                SelectableItem(title = "item 10"),
                SelectableItem(title = "item 11"),
                SelectableItem(title = "item 12"),
            )
        )
    }

    LazyColumn {
        items(items.size) { index ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = items[index].title
                )
                Checkbox(
                    checked = items[index].hasSelected,
                    onCheckedChange = {
                        items = items.mapIndexed{indexJ,item ->
                            if (index == indexJ) item.copy(hasSelected = it) else item
                        }
                })
            }
        }
    }

}