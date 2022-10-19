@file:Suppress("MagicNumber")

package com.example.androidapp.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.androidapp.R

val QuickSand = FontFamily(
    Font(R.font.quicksand_light, FontWeight.W300),
    Font(R.font.quicksand_regular, FontWeight.W400),
    Font(R.font.quicksand_medium, FontWeight.W500),
    Font(R.font.quicksand_bold, FontWeight.W600)
)

val AppTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.Normal,
        fontSize = 56.sp,
        lineHeight = 58.24.sp,
        letterSpacing = (-0.04).em,
        textAlign = TextAlign.Center,
        baselineShift = BaselineShift(0.2f),
    ),
    displayMedium = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.Normal,
        fontSize = 40.sp,
        lineHeight = 41.6.sp,
        letterSpacing = (-0.04).em,
        baselineShift = BaselineShift(0.2f)
    ),
    displaySmall = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp,
        lineHeight = 37.44.sp,
        letterSpacing = (-0.04).em,
        baselineShift = BaselineShift(0.2f)
    ),
    headlineLarge = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        lineHeight = 33.28.sp,
        letterSpacing = (-0.04).em,
        baselineShift = BaselineShift(0.2f)
    ),
    headlineMedium = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        lineHeight = 29.12.sp,
        letterSpacing = (-0.04).em,
        baselineShift = BaselineShift(0.2f)
    ),
    headlineSmall = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 24.96.sp,
        letterSpacing = (-0.04).em,
        baselineShift = BaselineShift(0.2f)
    ),
    titleLarge = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        lineHeight = 25.6.sp,
        letterSpacing = (-0.02).em,
        baselineShift = BaselineShift(0.2f)
    ),
    titleMedium = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = 23.04.sp,
        letterSpacing = (-0.02).em,
        baselineShift = BaselineShift(0.2f)
    ),
    titleSmall = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 20.48.sp,
        letterSpacing = (-0.02).em,
        baselineShift = BaselineShift(0.2f)
    ),
    bodyLarge = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 17.92.sp,
        letterSpacing = (0).em,
        baselineShift = BaselineShift(0.2f)
    ),
    bodyMedium = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
        lineHeight = 16.64.sp,
        letterSpacing = (0).em,
        baselineShift = BaselineShift(0.2f)
    ),
    bodySmall = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 15.36.sp,
        letterSpacing = (0).em,
        baselineShift = BaselineShift(0.2f)
    ),
    labelLarge = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp,
        lineHeight = 8.8.sp,
        letterSpacing = (0.02).em,
        baselineShift = BaselineShift(0.2f)
    ),
    // todo Enforce ALL_CAPS for Label_Medium
    labelMedium = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        lineHeight = 8.sp,
        letterSpacing = (0.04).em,
        baselineShift = BaselineShift(0.2f)
    ),
    // todo Enforce ALL_CAPS for Label_Small
    labelSmall = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.Normal,
        fontSize = 9.sp,
        lineHeight = 7.2.sp,
        letterSpacing = (0.04).em,
        baselineShift = BaselineShift(0.2f)
    )
)