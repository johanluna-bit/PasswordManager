package com.example.passwordmanager.ui.screens.add

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddViewModel: ViewModel() {

    private val _tittle = MutableLiveData<String>()
    private val _user = MutableLiveData<String>()
    private val _password= MutableLiveData<String>()
    private val _typeAccount = MutableLiveData<String>()
    private val _note = MutableLiveData<String>()

    val tittle: LiveData<String> = _tittle
    val user: LiveData<String> = _user
    val password: LiveData<String> = _password
    val typeAccount: LiveData<String> = _typeAccount
    val note: LiveData<String> = _note


    fun onTittleChange(tittle: String) {
        _tittle.value = tittle
    }

    fun onUserChange(user: String) {
        _user.value = user
    }

    fun onPasswordChange(password: String) {
        _password.value = password
    }

   fun onNoteChange(note: String) {
       _note.value = note
   }
}