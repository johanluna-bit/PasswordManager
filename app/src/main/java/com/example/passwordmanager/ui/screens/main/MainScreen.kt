package com.example.passwordmanager.ui.screens.main


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: MainViewModel, navController: NavHostController, modifier: Modifier = Modifier){

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Password Manager") },
                navigationIcon = { Icon(imageVector = Icons.Filled.Menu, contentDescription ="Menu Icon" ) }
            )
        },

        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.AddCircle , contentDescription ="Add Icon" )
            }
        }

    ){ContentPadding ->

        BodyContent(modifier = Modifier.padding(ContentPadding))
        Text(text = "Content")
    }
}

@Composable
fun TopBar() {
    TODO("Not yet implemented")
}

@Composable
fun BodyContent(modifier: Modifier = Modifier){
    Column(modifier = Modifier.fillMaxSize()){
        Text(text = "Contenido del Cuerpo")
    }
}

@Preview( showBackground = true,showSystemUi = true)
@Composable
fun MainScreenPreview(){

}