package com.example.passwordmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.passwordmanager.navigation.AppNavigation
import com.example.passwordmanager.ui.screens.add.AddScreen
import com.example.passwordmanager.ui.screens.login.LoginScreen
import com.example.passwordmanager.ui.screens.login.LoginViewModel
import com.example.passwordmanager.ui.theme.PasswordManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PasswordManagerTheme {

                //Controlador de la navegación
                AppNavigation()
                //AddScreen()
            }
        }
    }
}

