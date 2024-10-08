package com.example.gradienter.presentation.screens.editGradientScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.gradienter.presentation.theme.AppTheme
import com.example.gradienter.presentation.theme.mainTheme.MainTheme

@Composable
fun GradientColorSelector(
    modifier: Modifier = Modifier,
    color: Color,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .clickable(onClick = onClick)
            .background(color)
    )
}

@Preview
@Composable
private fun GradientColorSelectorPreview() {
    AppTheme(theme = MainTheme) {
        GradientColorSelector(
            onClick = {},
            color = Color.Green
        )
    }
}
