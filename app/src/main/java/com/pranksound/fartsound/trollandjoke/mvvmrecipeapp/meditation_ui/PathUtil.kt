package com.pranksound.fartsound.trollandjoke.mvvmrecipeapp.meditation_ui

 import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
 import androidx.compose.ui.graphics.Path
 import kotlin.math.abs

@Composable
fun Path.StandardQuadTo(from: Offset, to: Offset) {
    quadraticBezierTo(
        from.x,
        from.y,
        abs(from.x + to.x) / 2f,
        abs(from.y + to.y) / 2f
    )// tạo đường cong
}