package com.pranksound.fartsound.trollandjoke.mvvmrecipeapp.meditation_ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MeditationScreen() {
    val navHostController = rememberNavController()
    Scaffold(bottomBar = { BottomBar(navController = navHostController)}) {
        BottomNavGraph(navigation = navHostController)
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
    BottomAppBar {
        screens.forEach {
            AddItem(it, currentDestination, navController)
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: MenuBottomBarScreen,
    currentDestination: NavDestination?,
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