package com.pranksound.fartsound.trollandjoke.mvvmrecipeapp.meditation_ui

import android.icu.text.CaseMap.Title
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class MenuBottomBarScreen(
  val  route: String,
  val title: String,
  val icon: ImageVector
) {
    object Home : MenuBottomBarScreen(
        "home",
        "Home",
        Icons.Filled.Home
    )

    object Profile : MenuBottomBarScreen(
        "profile",
        "Profile",
        Icons.Filled.Person
    )

    object Settings : MenuBottomBarScreen(
        "settings",
        "Settings",
        Icons.Filled.Settings
    )
}
