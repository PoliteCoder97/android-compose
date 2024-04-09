package com.example.myapplication.meditation.models

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class Feature(
    var title: String,
    var backColor: Color,
    var mediumColor: Color,
    var lightColor: Color,
    @DrawableRes var icon: Int
)
