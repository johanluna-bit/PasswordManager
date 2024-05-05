package com.example.passwordmanager.ui.screens.login

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.passwordmanager.navigation.AppScreens
import kotlinx.coroutines.delay

class LoginViewModel: ViewModel() {


    //Declaración de variables MutableLiveData
    private val _email = MutableLiveData<String>()
    private val _password = MutableLiveData<String>()
    private val _loginEnable = MutableLiveData<Boolean>()
    private val _isLoading = MutableLiveData<Boolean>()

    //Declaración de variables LiveData
    val email: LiveData<String> = _email
    val password: LiveData<String> = _password
    val loginEnable: LiveData<Boolean> = _loginEnable
    val isLoading: LiveData<Boolean> = _isLoading


    //Función para cambiar el valor de las variables MutableLiveData
    fun onLoginChange(email: String , password: String) {
        _email.value = email
        _password.value = password

        _loginEnable.value = isValidEmail(email) && isValidPassword(password)
    }

    //Validaciones
    private fun isValidPassword(password: String): Boolean = password.length > 5
    private fun isValidEmail (email:String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()
    suspend fun onLoginSelect(navController: NavHostController) {


        _isLoading.value = true
        delay(3000)
        navController.popBackStack()
        _isLoading.value = false
        _loginEnable.value = false
        _email.value = ""
        _password.value = ""


        navController.navigate(AppScreens.MainScreen.route)
    }

}