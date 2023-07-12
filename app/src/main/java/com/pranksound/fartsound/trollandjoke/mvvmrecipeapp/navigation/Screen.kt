package com.pranksound.fartsound.trollandjoke.mvvmrecipeapp.navigation

sealed class Screen(val route: String) {
    object MainScreen : Screen("main _screen")
    object DetailScreen : Screen("detail_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach {
                append("/$it")
            }
        }
    }
}
