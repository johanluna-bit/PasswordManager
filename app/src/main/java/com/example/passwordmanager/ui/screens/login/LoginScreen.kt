package com.example.passwordmanager.ui.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.passwordmanager.R
import com.example.passwordmanager.navigation.AppScreens
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch



@Composable
fun LoginScreen (viewModel: LoginViewModel, navController: NavHostController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Login(Modifier.align(Alignment.Center), viewModel, navController)
    }
}

@Composable
fun Login(modifier: Modifier , viewModel: LoginViewModel, navController: NavHostController){

    val email: String by viewModel.email.observeAsState(initial = "")
    val password: String by viewModel.password.observeAsState(initial = "")
    val loginEnable: Boolean by viewModel.loginEnable.observeAsState(initial = false)

    val isLoading: Boolean by viewModel.isLoading.observeAsState(initial = false)
    val coroutineScope: CoroutineScope = rememberCoroutineScope()

    if(isLoading){
        Box(modifier = Modifier.fillMaxSize()){

            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }else{

        Column( modifier = modifier){

            HeaderText(modifier = Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.padding(16.dp))

            HeaderImage (
                Modifier
                    .align(Alignment.CenterHorizontally)
                    .height(250.dp))
            Spacer(modifier = Modifier.padding(16.dp))

            EmailField( email) { viewModel.onLoginChange(it , password) }
            Spacer(modifier = Modifier.padding(16.dp))

            PasswordField(password) { viewModel.onLoginChange(email , it) }
            Spacer(modifier = Modifier.padding(8.dp))

            NotAccountAlready(Modifier.align(Alignment.End), navController)
            Spacer(modifier = Modifier.padding(32.dp))

            LoginButton(loginEnable) {
                coroutineScope.launch {
                    viewModel.onLoginSelect(navController)
                }

            }
        }
    }


}

@Composable
fun LoginButton(loginEnable: Boolean , onLoginSelect: () -> Unit) {
    Button(
        onClick = { onLoginSelect() },
        modifier = Modifier.fillMaxWidth(),
        enabled = loginEnable,
    )
    {
        Text(text = "Iniciar Sesión")
    }
}

@Composable
fun NotAccountAlready(modifier: Modifier, navController: NavHostController) {
    Text(
        text = "¿No tienes una cuenta?",
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier.clickable {
            navController.navigate(AppScreens.RegisterScreen.route)},
    )
}


@Composable
fun PasswordField(password: String , onTextFieldChange: (String) -> Unit) {

    var passwordVisibility by rememberSaveable { mutableStateOf(false) }

    val icon =
        if (passwordVisibility){
        painterResource(id = R.drawable.password_eye_hiden)
    }else{
        painterResource(id = R.drawable.password_eye_open)
    }

    Row {
        Icon(
            imageVector = Icons.Filled.Lock ,
            contentDescription = "Email Icon",
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(end = 6.dp)
                .size(40.dp)
        )

        TextField(
            value = password , onValueChange = { onTextFieldChange(it) } ,
            modifier = Modifier.fillMaxWidth() ,
            placeholder = { Text(text = "Contraseña") } ,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password) ,
            singleLine = true ,
            maxLines = 1 ,

            trailingIcon = {
                IconButton(
                    onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                    Icon(
                        painter = icon,
                        contentDescription = "Password Icon",
                        Modifier.size( 30.dp)
                    )
                }
            },
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation()

        )
    }
}

@Composable
fun HeaderImage(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.logo_app ) , contentDescription = "Header Image",
        modifier = modifier.clip(RoundedCornerShape(16.dp))
    )

}

@Composable
fun HeaderText(modifier: Modifier = Modifier) {
    Text(
        text = "Bienvenido a Password Manager",
        fontWeight = FontWeight.Bold,
        fontSize = MaterialTheme.typography.titleLarge.fontSize,
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailField(email:String, onTextFieldChange: (String) -> Unit ) {

    Row {
        Icon(
            imageVector = Icons.Filled.Email ,
            contentDescription = "Email Icon" ,
            tint = MaterialTheme.colorScheme.primary ,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(end = 6.dp)
                .size(40.dp)
        )

        TextField(
            value = email , onValueChange = { onTextFieldChange(it) } ,
            modifier = Modifier.fillMaxWidth() ,
            placeholder = { Text(text = "Email") } ,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email) ,
            singleLine = true ,
            maxLines = 1 ,

            )
    }
}
