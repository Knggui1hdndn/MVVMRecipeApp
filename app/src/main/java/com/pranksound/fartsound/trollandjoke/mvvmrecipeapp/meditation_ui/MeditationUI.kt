package com.pranksound.fartsound.trollandjoke.mvvmrecipeapp.meditation_ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier

import com.pranksound.fartsound.trollandjoke.mvvmrecipeapp.meditation_ui.ui.theme.MVVMRecipeAppTheme

class MeditationUI : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVVMRecipeAppTheme {
                // A surface container using the 'background' color from the theme
               Column(modifier = Modifier.fillMaxSize()) {
                   MeditationScreen()
               }
            }
        }
    }
}

