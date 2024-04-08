package com.example.myapplication.widgets

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

@Composable
fun TextWidget(title: String) {
    val fontFamily = FontFamily(
        Font(R.font.lexend_black, weight = FontWeight.Black),
        Font(R.font.lexend_bold, weight = FontWeight.Bold),
        Font(R.font.lexend_extra_bold, weight = FontWeight.ExtraBold),
        Font(R.font.lexend_light, weight = FontWeight.ExtraLight),
        Font(R.font.lexend_light, weight = FontWeight.Light),
        Font(R.font.lexend_medium, weight = FontWeight.Medium),
        Font(R.font.lexend_regular, weight = FontWeight.Normal),
        Font(R.font.lexend_semi_bold, weight = FontWeight.SemiBold),
        Font(R.font.lexend_thin, weight = FontWeight.Thin),
    )
    Text(
        text = title,
        fontSize = 30.sp,
        color = Color(0xFF101010),
        fontFamily = fontFamily,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Italic,
        textDecoration = TextDecoration.Underline,
        textAlign = TextAlign.Center
    )
}