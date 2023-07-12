package com.pranksound.fartsound.trollandjoke.mvvmrecipeapp.meditation_ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

var height: Dp = 0.dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MeditationScreen() {
    val navHostController = rememberNavController()
    Scaffold(bottomBar = {
        BottomBar(navController = navHostController)
    }) {
        Box(modifier = Modifier.padding(bottom = 80.dp)) {
            BottomNavGraph(navigation = navHostController)
        }
    }
}

@Composable
fun BottomBar(navController: NavController) {
    val screens = listOf(
        MenuBottomBarScreen.Home,
        MenuBottomBarScreen.Profile,
        MenuBottomBarScreen.Settings,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    BottomAppBar(modifier = Modifier.height(80.dp)) {
        screens.forEach {
            AddItem(it, currentDestination, navController)
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: MenuBottomBarScreen,
    currentDestination: NavDestination?,//NavDestination đại diện cho một nút trong biểu đồ điều hướng tổng thể.
    navController: NavController
) {
    NavigationBarItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = "Navigation Icon"
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        onClick = {
            navController.navigate(screen.route)
        }
    )
}