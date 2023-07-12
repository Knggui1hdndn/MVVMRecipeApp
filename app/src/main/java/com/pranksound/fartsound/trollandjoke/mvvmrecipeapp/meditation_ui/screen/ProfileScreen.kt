package com.pranksound.fartsound.trollandjoke.mvvmrecipeapp.meditation_ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier.background(Color.Red).fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
     ) {
        Text(
            text = "ProfileScreen",
            fontSize = 25.sp,
            color = Color.Green
        )
        Text(
            text = "ProfileScreen",
            fontSize = 25.sp,
            color = Color.Green
        )
    }
}