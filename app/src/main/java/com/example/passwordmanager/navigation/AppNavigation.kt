package com.example.passwordmanager.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.passwordmanager.SplashScreen
import com.example.passwordmanager.ui.screens.login.LoginScreen
import com.example.passwordmanager.ui.screens.login.LoginViewModel


@Composable
fun AppNavigation(){

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppScreens.SplashScreen.route,
    ){
        //Builder de Rutas
        composable(AppScreens.SplashScreen.route){
            SplashScreen(navController)
        }

        //Ruta para LoginScreen a MainScreen
        composable(AppScreens.LoginScreen.route){
            LoginScreen(viewModel = LoginViewModel())
        }

    }
}