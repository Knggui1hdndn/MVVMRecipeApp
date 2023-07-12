package com.pranksound.fartsound.trollandjoke.mvvmrecipeapp.meditation_ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun SettingsScreen() {
    Box(modifier = Modifier.background(Color.Blue), contentAlignment = Alignment.Center) {
        Text(
            text = "SettingsScreen",
            fontSize = 25.sp,
            color = Color.Green
        )

    }
}