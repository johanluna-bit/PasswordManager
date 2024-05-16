package com.example.passwordmanager.ui.screens.option

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.passwordmanager.navigation.AppScreens

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun InfoScreen(navController: NavHostController){
    Scaffold (
        topBar = { TopBar(navController) },
        content = { BodyContent() },
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
                text = "Acerca de",
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


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun BodyContent(modifier: Modifier = Modifier){

    Column (
        Modifier
            .fillMaxSize()
            .padding(top = 90.dp , start = 10.dp , end = 10.dp)
    )
    {
        Text(
            text ="PASSWORD MANAGER",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Icon(
            imageVector = Icons.Filled.Info,
            contentDescription = "Info Icon",
            modifier = Modifier
                .padding(top = 40.dp)
                .size(100.dp)
                .fillMaxWidth()
                .align(alignment = androidx.compose.ui.Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.size(30.dp))
        Text(
            text = "Proyecto de Android",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.size(40.dp))

        Text(
            text = "Desarrollado Por:",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )

        Text(

            text = "Jefferson Jhoan Luna Lopez",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
    }
}

