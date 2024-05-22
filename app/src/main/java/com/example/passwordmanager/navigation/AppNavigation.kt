package com.example.passwordmanager.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.passwordmanager.SplashScreen
import com.example.passwordmanager.data.item.ItemsViewModel
import com.example.passwordmanager.ui.screens.login.LoginScreen
import com.example.passwordmanager.ui.screens.login.LoginViewModel
import com.example.passwordmanager.ui.screens.main.AddScreen
import com.example.passwordmanager.ui.screens.main.EditScreen
import com.example.passwordmanager.ui.screens.main.MainScreen
import com.example.passwordmanager.ui.screens.option.AdjustScreen
import com.example.passwordmanager.ui.screens.option.InfoScreen
import com.example.passwordmanager.ui.screens.option.OptionScreen
import com.example.passwordmanager.ui.screens.register.RegisterScreen
import com.example.passwordmanager.ui.screens.register.RegisterViewModel


@Composable
fun AppNavigation(viewModel: ItemsViewModel){

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppScreens.SplashScreen.route, // ¡Cambiar Ruta a SplashScreen al terminar!
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

        //Ruta para MainScreen a AddScreen que utilizan [ROOM]
        composable("main_screen"){
            MainScreen(navController, viewModel)
        }

        composable(AppScreens.AddScreen.route){
            AddScreen(navController , viewModel)
        }

        composable(
            "edit_screen/{id}/{tittle}/{email}/{password}/{typeAccount}/{description}",
            arguments = listOf(
                navArgument("id"){type = NavType.IntType},
                navArgument("tittle"){type = NavType.StringType},
                navArgument("email"){type = NavType.StringType},
                navArgument("password"){type = NavType.StringType},
                navArgument("typeAccount"){type = NavType.StringType},
                navArgument("description"){type = NavType.StringType},
            )
        ){
            EditScreen(
                navController,
                viewModel,
                it.arguments!!.getInt("id"),
                it.arguments?.getString("tittle"),
                it.arguments?.getString("email"),
                it.arguments?.getString("password"),
                it.arguments?.getString("typeAccount"),
                it.arguments?.getString("description")
                )
        }
        //------------------------------------------------------------------------------------------

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