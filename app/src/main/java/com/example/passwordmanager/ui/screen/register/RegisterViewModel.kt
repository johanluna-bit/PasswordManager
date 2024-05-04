package com.example.passwordmanager.ui.screen.register

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay

class RegisterViewModel: ViewModel() {


    //Declaración de variables MutableLiveData
    private val _email = MutableLiveData<String>()
    private val _password = MutableLiveData<String>()
    private val _registerEnable = MutableLiveData<Boolean>()
    private val _isLoading = MutableLiveData<Boolean>()

    //Declaración de variables LiveData
    val email: LiveData<String> = _email
    val password: LiveData<String> = _password
    val registerEnable: LiveData<Boolean> = _registerEnable
    val isLoading: LiveData<Boolean> = _isLoading


    //Función para cambiar el valor de las variables MutableLiveData
    fun onLoginChange(email: String , password: String) {
        _email.value = email
        _password.value = password

        _registerEnable.value = isValidEmail(email) && isValidPassword(password)
    }

    //Validaciones
    private fun isValidPassword(password: String): Boolean = password.length > 5
    private fun isValidEmail (email:String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()
    suspend fun onLoginSelect() {

        _isLoading.value = true
        delay(4000)
        _isLoading.value = false
    }

}