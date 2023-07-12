package com.pranksound.fartsound.trollandjoke.mvvmrecipeapp.custom_component

import android.util.Log
import androidx.compose.animation.Animatable
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CustomComponent(
    canvasSize: Dp = 300.dp,
    indicatorValue: Int = 50,
    maxIndicatorValue: Int = 100,
    backgroundIndicatorColor: Color = Color.Gray.copy(alpha = 0.3f),
    backgroundIndicatorStrokeWith: Float = 100f,
    foregroundIndicatorColor: Color = Color.Blue,
    foregroundIndicatorStrokeWith: Float = 100f,
) {
    var animatedIndicatorValue = remember {
        mutableStateOf(0f)
    }//một biến mutable state cung cấp khả năng tạo và quản lý animation
    var animatedValue = remember {
        mutableStateOf(0f)
    }
//    LaunchedEffect(key1 = animatedIndicatorValue) {// được gọi khi giá trị key thay đổi
//        animatedIndicatorValue.value=indicatorValue.toFloat()//thực hiện animation tới vị trí nào đó
//    } //giá trị của animatedIndicatorValue thay đổi liên tục
Log.d("ádaaaaaa",animatedIndicatorValue.value.toString())
    val percentage = (animatedIndicatorValue.value / maxIndicatorValue) * 100//phần trăm
    val sweepAngle by animateFloatAsState(//góc quét
        targetValue = (2.4 * percentage).toFloat(), animationSpec = tween(10000)
    )
    val receiverValue by animateIntAsState(//góc quét
        targetValue = animatedValue.value.toInt(), animationSpec = tween(10000)
    )
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(modifier = Modifier
            .size(canvasSize)
            .drawBehind {
                val componentSize = size
                backgroundIndicator(
                    componentSize = componentSize,
                    indicatorColor = backgroundIndicatorColor,
                    indicatorStrokeWidth = backgroundIndicatorStrokeWith
                )
                foregroundIndicator(
                    sweepAngle = sweepAngle,
                    componentSize = componentSize,
                    indicatorColor = foregroundIndicatorColor,
                    indicatorStrokeWidth = foregroundIndicatorStrokeWith
                )
            }) {}
        Text(text = "$receiverValue/$maxIndicatorValue")
    }
}

fun DrawScope.foregroundIndicator(
    componentSize: Size,
    indicatorColor: Color,
    indicatorStrokeWidth: Float,
    sweepAngle: Float,
) {
    drawArc(
        size = componentSize,
        color = indicatorColor,
        startAngle = 150f,
        sweepAngle = sweepAngle,
        useCenter = false,
        style = Stroke(
            width = indicatorStrokeWidth, cap = StrokeCap.Round
        )
    )
}

fun DrawScope.backgroundIndicator(
    componentSize: Size, indicatorColor: Color, indicatorStrokeWidth: Float
) {
    drawArc(
        size = componentSize,
        color = indicatorColor,
        startAngle = 150f,
        sweepAngle = 240f,
        useCenter = false,
        style = Stroke(
            width = indicatorStrokeWidth, cap = StrokeCap.Round
        )
    )
}

@Composable
@Preview(showSystemUi = true)
fun CustomComponentPreview() {
    CustomComponent()
}