package com.pranksound.fartsound.trollandjoke.mvvmrecipeapp.meditation_ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pranksound.fartsound.trollandjoke.mvvmrecipeapp.custom_component.CustomComponent
import com.pranksound.fartsound.trollandjoke.mvvmrecipeapp.meditation_ui.screen.HomeScreen
import com.pranksound.fartsound.trollandjoke.mvvmrecipeapp.meditation_ui.screen.ProfileScreen
import com.pranksound.fartsound.trollandjoke.mvvmrecipeapp.meditation_ui.screen.SettingsScreen

@Composable
fun BottomNavGraph(navigation: NavHostController) {
    NavHost(navController = navigation, startDestination = MenuBottomBarScreen.Home.route) {
        composable(route = MenuBottomBarScreen.Home.route) {
            HomeScreen()
        }
        composable(route = MenuBottomBarScreen.Profile.route) {
            ProfileScreen()
        }
        composable(route = MenuBottomBarScreen.Settings.route) {
            CustomComponent()
        }
    }
}