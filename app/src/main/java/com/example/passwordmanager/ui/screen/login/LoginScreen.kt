package com.example.passwordmanager.ui.screen.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.passwordmanager.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun LoginScreen (viewModel: LoginViewModel){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Login(Modifier.align(Alignment.Center), viewModel)
    }
}

@Composable
fun Login(modifier: Modifier , viewModel: LoginViewModel){

    val email: String by viewModel.email.observeAsState(initial = "")
    val password: String by viewModel.password.observeAsState(initial = "")
    val loginEnable: Boolean by viewModel.loginEnable.observeAsState(initial = false)

    val isLoading: Boolean by viewModel.isLoading.observeAsState(initial = false)
    val corutineScope: CoroutineScope = rememberCoroutineScope()

    if(isLoading){
        Box(modifier = Modifier.fillMaxSize()){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }else{

        Column( modifier = modifier){
            HeaderImage (
                Modifier
                    .align(Alignment.CenterHorizontally)
                    .height(250.dp))
            Spacer(modifier = Modifier.padding(16.dp))

            EmailField( email) { viewModel.onLoginChange(it , password) }
            Spacer(modifier = Modifier.padding(16.dp))

            PasswordField(password) { viewModel.onLoginChange(email , it) }
            Spacer(modifier = Modifier.padding(8.dp))

            ForgotPassword(Modifier.align(Alignment.End))
            Spacer(modifier = Modifier.padding(8.dp))

            LoginButton(loginEnable) {
                corutineScope.launch {
                    viewModel.onLoginSelect()
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
fun ForgotPassword(modifier: Modifier) {
    Text(
        text = "¿Ya tienes una cuenta?" ,
        modifier = modifier.clickable { /*TODO*/ },
    )
}

@Composable
fun PasswordField(password: String , onTextFieldChange: (String) -> Unit) {
    TextField(
        value = password , onValueChange = { onTextFieldChange(it)},
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Contraseña") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        maxLines = 1,
    )
}

@Composable
fun HeaderImage(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.logo_app ) , contentDescription = "Header Image",
        modifier = modifier,
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailField(email:String, onTextFieldChange: (String) -> Unit ) {

    TextField(
        value = email , onValueChange = {onTextFieldChange(it)},
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Email") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,

    )
}
