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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.passwordmanager.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreen (){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Login(Modifier.align(Alignment.Center))
    }
}

@Composable
fun Login( modifier: Modifier){
    Column( modifier = modifier){
        HeaderImage (
            Modifier
                .align(Alignment.CenterHorizontally)
                .height(250.dp))
        Spacer(modifier = Modifier.padding(16.dp))

        EmailField()
        Spacer(modifier = Modifier.padding(16.dp))

        PasswordField()
        Spacer(modifier = Modifier.padding(8.dp))

        ForgotPassword(Modifier.align(Alignment.End))
        Spacer(modifier = Modifier.padding(8.dp))

        LoginButton()
    }

}

@Composable
fun LoginButton() {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier.fillMaxWidth(),
        enabled = true,
    ){
        Text(text = "Ingresar")
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
fun PasswordField() {
    TextField(
        value = "" , onValueChange = {},
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
fun EmailField() {
    TextField(
        value = "" , onValueChange = {},
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Email") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,

    )
}
