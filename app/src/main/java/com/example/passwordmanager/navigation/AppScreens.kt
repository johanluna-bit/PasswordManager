package com.example.passwordmanager.navigation

sealed class AppScreens (val route: String){

    object LoginScreen: AppScreens("login_screen")
    object SplashScreen: AppScreens("splash_screen")

    object RegisterScreen: AppScreens("register_screen")

    object MainScreen: AppScreens("main_screen")

    object AddScreen: AppScreens("add_screen")

    object EditScreen: AppScreens("edit_screen")

    object OptionScreen: AppScreens("option_screen")

    object InfoScreen: AppScreens("info_screen")

    object AdjustScreen: AppScreens("adjust_screen")
}