package com.example.passwordmanager.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.passwordmanager.SplashScreen
import com.example.passwordmanager.ui.screens.add.AddScreen
import com.example.passwordmanager.ui.screens.add.AddViewModel
import com.example.passwordmanager.ui.screens.login.LoginScreen
import com.example.passwordmanager.ui.screens.login.LoginViewModel
import com.example.passwordmanager.ui.screens.main.MainScreen
import com.example.passwordmanager.ui.screens.main.MainViewModel
import com.example.passwordmanager.ui.screens.option.AdjustScreen
import com.example.passwordmanager.ui.screens.option.InfoScreen
import com.example.passwordmanager.ui.screens.option.OptionScreen
import com.example.passwordmanager.ui.screens.register.RegisterScreen
import com.example.passwordmanager.ui.screens.register.RegisterViewModel


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
            LoginScreen(viewModel = LoginViewModel(), navController)
        }

        composable(AppScreens.RegisterScreen.route){
            RegisterScreen(viewModel = RegisterViewModel(), navController)
        }

        composable(AppScreens.MainScreen.route){
            MainScreen(viewModel = MainViewModel(), navController)
        }

        composable(AppScreens.AddScreen.route){
            AddScreen(viewModel = AddViewModel() , navController)
        }

        composable(AppScreens.OptionScreen.route){
            OptionScreen(navController)
        }

        composable(AppScreens.InfoScreen.route){
            InfoScreen(navController)
        }

        composable(AppScreens.AdjustScreen.route){
            AdjustScreen(navController)
        }

    }
}