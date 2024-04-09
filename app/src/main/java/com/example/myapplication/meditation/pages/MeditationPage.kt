package com.example.myapplication.meditation.pages

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.meditation.models.BottomMenuContent
import com.example.myapplication.meditation.models.Feature
import com.example.myapplication.ui.theme.AquaBlue
import com.example.myapplication.ui.theme.Beige1
import com.example.myapplication.ui.theme.Beige2
import com.example.myapplication.ui.theme.Beige3
import com.example.myapplication.ui.theme.BlueViolet1
import com.example.myapplication.ui.theme.BlueViolet2
import com.example.myapplication.ui.theme.BlueViolet3
import com.example.myapplication.ui.theme.ButtonBlue
import com.example.myapplication.ui.theme.DarkerButtonBlue
import com.example.myapplication.ui.theme.DeepBlue
import com.example.myapplication.ui.theme.LightGreen1
import com.example.myapplication.ui.theme.LightGreen2
import com.example.myapplication.ui.theme.LightGreen3
import com.example.myapplication.ui.theme.LightRed
import com.example.myapplication.ui.theme.OrangeYellow1
import com.example.myapplication.ui.theme.OrangeYellow2
import com.example.myapplication.ui.theme.OrangeYellow3
import com.example.myapplication.ui.theme.TextWhite
import com.example.myapplication.utils.standardQuadFromTo

@Composable
fun MeditationPage() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DeepBlue)
    ) {
        Column {
            BuildHeader(name = "PoliteCoder")
            CheepSection(listOf("Sweet sleep", "Insomnia", "Depression"))
            CurrentMeditation()
            FeatureSection(
                listOf<Feature>(
                    Feature(
                        title = "Sleep meditation",
                        icon = R.drawable.ic_headphone,
                        backColor = BlueViolet3,
                        lightColor = BlueViolet1,
                        mediumColor = BlueViolet2,
                    ), Feature(
                        title = "Tips for sleeping",
                        icon = R.drawable.ic_videocam,
                        backColor = LightGreen3,
                        lightColor = LightGreen1,
                        mediumColor = LightGreen2,
                    ), Feature(
                        title = "Night island",
                        icon = R.drawable.ic_headphone,
                        backColor = OrangeYellow3,
                        lightColor = OrangeYellow1,
                        mediumColor = OrangeYellow2,
                    ), Feature(
                        title = "Calming sounds",
                        icon = R.drawable.ic_headphone,
                        backColor = Beige3,
                        lightColor = Beige1,
                        mediumColor = Beige2,
                    )

                )
            )
        }
        BottomMenu(items = listOf(
            BottomMenuContent("Home", R.drawable.ic_home),
            BottomMenuContent("Meditate", R.drawable.ic_bubble),
            BottomMenuContent("Sleep", R.drawable.ic_moon),
            BottomMenuContent("Music", R.drawable.ic_music),
            BottomMenuContent("Profile", R.drawable.ic_profile),
        ), modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun BottomMenu(
    items: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    initialSelectedItemIndex: Int = 0
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(15.dp)
    ) {
        items.forEachIndexed { index, item ->
            BottomMenuItem(
                item = item,
                isSelected = index == selectedItemIndex,
                activeHighlightColor = activeHighlightColor,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor
            ) {
                selectedItemIndex = index
            }
        }
    }
}

@Composable
fun BottomMenuItem(
    item: BottomMenuContent,
    isSelected: Boolean = false,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    onItemClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighlightColor else Color.Transparent)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = item.title,
                tint = if (isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(20.dp)
            )
        }
        Text(
            text = item.title,
            color = if(isSelected) activeTextColor else inactiveTextColor
        )
    }
}

@Composable
fun FeatureSection(listOf: List<Feature>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Text(
            text = "Features",
            style = MaterialTheme.typography.headlineLarge,
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(4.dp),
        ) {
            items(listOf.size) { index ->
                FutureItem(listOf[index])
            }
        }
    }
}

@Composable
fun FutureItem(feature: Feature) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
            .aspectRatio(1f)
            .clip(RoundedCornerShape(8.dp))
            .background(feature.backColor)
            .padding(8.dp)
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        // Medium colored path
        val mediumColoredPoint1 = Offset(0f, height * 0.3f)
        val mediumColoredPoint2 = Offset(width * 0.1f, height * 0.35f)
        val mediumColoredPoint3 = Offset(width * 0.4f, height * 0.05f)
        val mediumColoredPoint4 = Offset(width * 0.75f, height * 0.7f)
        val mediumColoredPoint5 = Offset(width * 1.4f, -height.toFloat())

        val mediumColoredPath = Path().apply {
            moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)
            standardQuadFromTo(mediumColoredPoint1, mediumColoredPoint2)
            standardQuadFromTo(mediumColoredPoint2, mediumColoredPoint3)
            standardQuadFromTo(mediumColoredPoint3, mediumColoredPoint4)
            standardQuadFromTo(mediumColoredPoint4, mediumColoredPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        // Light colored path
        val lightPoint1 = Offset(0f, height * 0.35f)
        val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
        val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
        val lightPoint4 = Offset(width * 0.65f, height.toFloat())
        val lightPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)

        val lightColoredPath = Path().apply {
            moveTo(lightPoint1.x, lightPoint1.y)
            standardQuadFromTo(lightPoint1, lightPoint2)
            standardQuadFromTo(lightPoint2, lightPoint3)
            standardQuadFromTo(lightPoint3, lightPoint4)
            standardQuadFromTo(lightPoint4, lightPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }
        Canvas(
            modifier = Modifier.fillMaxSize()
        ) {
            drawPath(
                path = mediumColoredPath, color = feature.mediumColor
            )
            drawPath(
                path = lightColoredPath, color = feature.lightColor
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Text(
                text = feature.title,
                style = MaterialTheme.typography.headlineMedium,
                lineHeight = 26.sp,
                modifier = Modifier.align(Alignment.TopStart)
            )
            Icon(
                painter = painterResource(id = feature.icon),
                contentDescription = feature.title,
                tint = Color.White,
                modifier = Modifier.align(Alignment.BottomStart)
            )
            Text(text = "Start",
                color = TextWhite,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable {
                        // Handle the click
                    }
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(ButtonBlue)
                    .padding(vertical = 6.dp, horizontal = 15.dp))
        }
    }
}

@Composable
fun CurrentMeditation() {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(LightRed)
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Daily Thought",
                    style = MaterialTheme.typography.headlineMedium,
                    color = TextWhite
                )
                Text(
                    text = "Meditation . 3-10 min",
                    style = MaterialTheme.typography.bodySmall,
                    color = TextWhite
                )
            }
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(ButtonBlue)
                    .padding(8.dp)
                    .clickable { }, contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_play),
                    contentDescription = "play",
                    tint = Color.White,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}

@Composable
fun CheepSection(items: List<String>) {
    var selectedIndex by remember {
        mutableStateOf(0)
    }
    LazyRow(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(items.size) { index ->
            CheepItem(
                modifier = Modifier.clickable {
                    selectedIndex = index
                }, item = items[index], hasSelected = selectedIndex == index
            )
        }
    }
}

@Composable
fun CheepItem(modifier: Modifier = Modifier, item: String, hasSelected: Boolean) {
    Box(
        modifier = modifier
            .padding(
                horizontal = 6.dp, vertical = 15.dp
            )
            .clip(RoundedCornerShape(8.dp))
            .background(if (hasSelected) ButtonBlue else DarkerButtonBlue)
            .padding(
                horizontal = 15.dp, vertical = 15.dp
            )
    ) {
        Text(
            text = item, style = MaterialTheme.typography.bodySmall, color = TextWhite
        )
    }
}

@Composable
fun BuildHeader(name: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = "Good Morning, $name", style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = "We wish you have a good day!", style = MaterialTheme.typography.bodyMedium
            )
        }
        Icon(painter = painterResource(id = R.drawable.ic_search),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .size(24.dp)
                .clickable { })
    }
}
