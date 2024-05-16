package com.example.passwordmanager.ui.screens.option

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.passwordmanager.navigation.AppScreens


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AdjustScreen(navController: NavHostController){
    Scaffold (
        topBar = { TopBar(navController) },
        content = { BodyContent(navController) },
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private  fun TopBar(navController: NavHostController) {
    TopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
        ),

        title = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Ajustes",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
        },

        navigationIcon = { GoBackButton(navController) }
    )
}


@Composable
private fun GoBackButton(navController: NavHostController) {

    Icon(
        imageVector = Icons.Filled.ArrowBack,
        contentDescription ="Arrow Back Icon",

        modifier = Modifier
            .padding(start = 13.dp)
            .size(35.dp)
            .fillMaxWidth()
            .clickable {
                navController.popBackStack()
                navController.navigate(AppScreens.OptionScreen.route)
            },
    )
}


@Composable
private fun BodyContent(navController: NavHostController){

    Column (
        Modifier
            .fillMaxSize()
            .padding(top = 90.dp , start = 10.dp , end = 10.dp)
    )
    {
        ExportPassword()
        Spacer(modifier = Modifier.size(10.dp))
        ImportPassword()
        Spacer(modifier = Modifier.size(10.dp))
        ChangeTheme()
    }
}

@Composable
private fun ExportPassword(){
    Row (
        modifier = Modifier.clickable {  }
    ) {
        IconButton(
            onClick = {}
        ) {
            Image(imageVector = Icons.Filled.Share, contentDescription ="Exports Passwords")
            Modifier
                .fillMaxWidth()
                .size(70.dp)

        }
        Text(
            text = "Exportar Contraseñas",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 16.dp)
                .align(Alignment.CenterVertically)
                .fillMaxWidth()
        )
    }
}

@Composable
private fun ImportPassword(){

    Row (
        modifier = Modifier.clickable {   }
    ) {
        IconButton(
            onClick = {}
        ) {
            Image(imageVector = Icons.Filled.Star, contentDescription ="Import Passwords")
            Modifier
                .fillMaxWidth()
                .size(70.dp)
        }
        Text(
            text = "Importar Contraseñas",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 16.dp)
                .align(Alignment.CenterVertically)
                .fillMaxWidth()
        )
    }
}

@Composable
private fun ChangeTheme(){

    Row (
        modifier = Modifier.clickable {
        }
    ) {
        IconButton(
            onClick = {}
        ) {
            Image(imageVector = Icons.Filled.Create, contentDescription ="Change Theme")
            Modifier
                .fillMaxWidth()
                .size(70.dp)
        }
        Text(
            text = "Cambiar Tema del App",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 16.dp)
                .align(Alignment.CenterVertically)
                .fillMaxWidth()
        )
    }
}



