package com.jetpack.numberpicker

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun PickerButton(
    size: Dp = 45.dp,
    @DrawableRes drawable: Int = R.drawable.ic_arrow_left,
    enabled: Boolean = true,
    onClick: () -> Unit = {}
) {
    val contentDesc = LocalContext.current.resources.getResourceName(drawable)
    val backgroundColor = if (enabled) MaterialTheme.colors.secondary else Color.LightGray

    Image(
        painter = painterResource(id = drawable),
        contentDescription = contentDesc,
        modifier = Modifier
            .padding(8.dp)
            .background(backgroundColor, CircleShape)
            .clip(CircleShape)
            .size(size = size)
            .clickable(
                enabled = enabled,
                onClick = { onClick() }
            )
    )
}




















