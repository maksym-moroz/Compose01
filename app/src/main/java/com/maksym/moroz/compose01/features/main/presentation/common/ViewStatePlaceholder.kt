package com.maksym.moroz.compose01.features.main.presentation.common

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
inline fun ViewStatePlaceholder(
    @StringRes placeholder: Int,
    modifier: Modifier.() -> Modifier = { this },
) {
    Box(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxWidth()
            .modifier(),
        contentAlignment = Alignment.TopCenter,
    ) {
        Text(
            text = stringResource(placeholder),
            modifier = Modifier
                .padding(16.dp),
            color = Color.White,
            fontSize = 16.sp,
        )
    }
}