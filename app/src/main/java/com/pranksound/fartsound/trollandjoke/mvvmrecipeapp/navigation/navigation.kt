package com.pranksound.fartsound.trollandjoke.mvvmrecipeapp.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(
            route = Screen.DetailScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "Khang"
                    nullable = true
                }
            )
        ) { back ->
            DetailScreen(name = back.arguments?.getString("name").toString())
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController) {
    var text by remember {
        mutableStateOf("")
    }
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(50.dp)
            .background(Color.Gray)

    ) {
        TextField(
            value = text, onValueChange = { text = it },
            modifier = Modifier.fillMaxWidth()
        )
        Button(onClick = {
            navController.navigate(Screen.DetailScreen.withArgs(text))
        }, modifier = Modifier.height(50.dp)) {
            Text(text = "To DetailScreen")
        }
    }
}

@Composable
fun DetailScreen(name: String) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(Color.Blue)) {
        Text(text = "Hello $name")

    }
}