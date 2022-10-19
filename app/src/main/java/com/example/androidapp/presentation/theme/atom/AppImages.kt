package com.example.androidapp.presentation.theme.atom

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import com.example.androidapp.R

@Composable
fun Image(
    modifier: Modifier = Modifier,
    url: String? = null,
    @DrawableRes drawable: Int = -1,
    error: Painter = painterResource(id = R.drawable.ic_error),
    contentScale: ContentScale = ContentScale.None
) {
    val singleDrawableRes = (url == null && drawable != -1) || (url != null && drawable == -1)
    require(singleDrawableRes) {
        "Exactly one image resource must be passed for image, either from local or from URL."
    }
    AsyncImage(
        modifier = modifier,
        model = if (drawable != -1) drawable else url,
        contentDescription = null,
        contentScale = contentScale,
        error = error
    )
}