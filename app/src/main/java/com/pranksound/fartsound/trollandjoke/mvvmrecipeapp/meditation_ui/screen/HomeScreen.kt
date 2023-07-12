package com.pranksound.fartsound.trollandjoke.mvvmrecipeapp.meditation_ui.screen


import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pranksound.fartsound.trollandjoke.mvvmrecipeapp.R
import com.pranksound.fartsound.trollandjoke.mvvmrecipeapp.meditation_ui.Feature
import com.pranksound.fartsound.trollandjoke.mvvmrecipeapp.meditation_ui.StandardQuadTo
import com.pranksound.fartsound.trollandjoke.mvvmrecipeapp.meditation_ui.ui.theme.BlueViolet1
import com.pranksound.fartsound.trollandjoke.mvvmrecipeapp.meditation_ui.ui.theme.BlueViolet2
import com.pranksound.fartsound.trollandjoke.mvvmrecipeapp.meditation_ui.ui.theme.BlueViolet3
import com.pranksound.fartsound.trollandjoke.mvvmrecipeapp.meditation_ui.ui.theme.ButtonBlue
import com.pranksound.fartsound.trollandjoke.mvvmrecipeapp.meditation_ui.ui.theme.DarkerButtonBlue
import com.pranksound.fartsound.trollandjoke.mvvmrecipeapp.meditation_ui.ui.theme.DeepBlue
import com.pranksound.fartsound.trollandjoke.mvvmrecipeapp.meditation_ui.ui.theme.LightRed

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
            .padding(15.dp)
    ) {
        Column {
            GreetingSection()
            Spacer(modifier = Modifier.height(25.dp))
            ChipSection(chip = listOf("Sweet sleep", "Insomnia", "Depression"))
            Spacer(modifier = Modifier.height(25.dp))
            CurrentMeditation()
            Spacer(modifier = Modifier.height(25.dp))
            FeaturedSection(
                listOf(
                    Feature(
                        "Sleep Meditation",
                        R.drawable.baseline_headphones_24,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3,
                    ),
                    Feature(
                        "Tips for Sleeping", R.drawable.baseline_videocam_24,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3,
                    ),
                    Feature(
                        "Sleep Meditation",
                        R.drawable.baseline_headphones_24,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3,
                    ),
                    Feature(
                        "Tips for Sleeping", R.drawable.baseline_videocam_24,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3,
                    ),
                    Feature(
                        "Sleep Meditation",
                        R.drawable.baseline_headphones_24,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3,
                    ),
                    Feature(
                        "Tips for Sleeping", R.drawable.baseline_videocam_24,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3,
                    ),
                    Feature(
                        "Sleep Meditation",
                        R.drawable.baseline_headphones_24,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3,
                    ),
                    Feature(
                        "Tips for Sleeping", R.drawable.baseline_videocam_24,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3,
                    )
                )
            )
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun Preview() {
    Column {
        HomeScreen()
    }
}

@Composable
fun GreetingSection(name: String = "Nguyễn Khang") {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = "Good Morning, $name",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Text(text = "Good Morning, $name", color = ButtonBlue)
        }
        Icon(Icons.Filled.Search, contentDescription = "search", tint = Color.White)
    }
}

@Composable
fun ChipSection(chip: List<String>) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }
    LazyRow {
        items(chip.size) {
            Box(
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .clickable {
                        selectedChipIndex = it
                    }
                    .background(if (it == selectedChipIndex) ButtonBlue else DarkerButtonBlue)
                    .padding(15.dp)

            ) {
                Text(text = chip[it], color = Color.White)
            }
        }
    }
}

@Composable
fun CurrentMeditation(
    color: Color = LightRed
) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .padding(0.dp)
            .background(color)
            .fillMaxWidth()
            .padding(15.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = "Daily Thought",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Text(text = "Meditation . 3-10 min", color = Color.White, fontWeight = FontWeight.Thin)
        }

        Box(
            modifier = Modifier
                .height(40.dp)
                .width(40.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(ButtonBlue),
            contentAlignment = Alignment.Center

        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_not_started_24),
                contentDescription = "search",
                tint = Color.White
            )
        }
    }
}

@Composable
fun FeaturedSection(features: List<Feature>) {
    Column {
        Text(
            text = "Featured",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(horizontal = 1.dp),
            modifier = Modifier
                .padding(top = 25.dp)
                .fillMaxSize()
        ) {
            items(features.size) {
                FeatureItem(feature = features[it])
            }
        }
    }
}

@Composable
fun FeatureItem(feature: Feature) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(feature.darkColor)
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight
        // Medium colored path
        val mediumColoredPoint1 = Offset(2f, height * 0.3f)
        val mediumColoredPoint2 = Offset(width * 0.1f, height * 0.35f)
        val mediumColoredPoint3 = Offset(width * 0.4f, height * 0.05f)
        val mediumColoredPoint4 = Offset(width * 0.75f, height * 0.7f)
        val mediumColoredPoint5 = Offset(width * 1.4f, -height.toFloat())
        val mediumPath = Path().apply {
            moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)
            StandardQuadTo(from = mediumColoredPoint1, to = mediumColoredPoint2)//Tạo đường cong
            StandardQuadTo(from = mediumColoredPoint2, to = mediumColoredPoint3)
            StandardQuadTo(from = mediumColoredPoint3, to = mediumColoredPoint4)
            StandardQuadTo(from = mediumColoredPoint4, to = mediumColoredPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawPath(path = mediumPath, color = feature.mediumColor)
            drawPath(path = mediumPath, color = feature.lightColor)
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Text(
                lineHeight = 26.sp,
                text = feature.title,
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.align(Alignment.TopStart)
            )
            Icon(
                painter = painterResource(id = feature.iconId),
                "",
                tint = Color.White,
                modifier = Modifier.align(Alignment.BottomStart)
            )
            Box(modifier = Modifier
                .padding(0.dp)
                .align(Alignment.BottomEnd)
                .clip(RoundedCornerShape(10.dp))
                .background(ButtonBlue)
                .padding(12.dp)
                .clickable {
                    Log.d("ssssssssssss", feature.title)
                }) {
                Text(
                    color = Color.White,
                    text = "Start",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .clip(RoundedCornerShape(10.dp))
                        .background(ButtonBlue)
                )
            }
        }
    }
}