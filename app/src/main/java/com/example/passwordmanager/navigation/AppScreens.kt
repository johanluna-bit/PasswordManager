package com.example.passwordmanager.navigation

sealed class AppScreens (val route: String){

    object LoginScreen: AppScreens("login_screen")
    object SplashScreen: AppScreens("splash_screen")

    object RegisterScreen: AppScreens("register_screen")
}