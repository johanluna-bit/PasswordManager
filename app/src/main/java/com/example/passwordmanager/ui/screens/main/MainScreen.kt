package com.example.passwordmanager.ui.screens.main


import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.passwordmanager.navigation.AppScreens


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(viewModel: MainViewModel, navController: NavHostController ){

    Scaffold(

        topBar = { TopBar()},
        content = { BodyContent()},
        floatingActionButton = { AddButton(navController) },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar() {
    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Password Manager",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center,
            )},

        navigationIcon = { MenuButton()}
    )
}

@Composable
private fun MenuButton(){
    Icon(
        imageVector = Icons.Filled.Menu,
        contentDescription ="Menu Icon",

        modifier = Modifier
            .padding(start = 13.dp)
            .size(35.dp)
            .fillMaxWidth()
            .clickable { },
    )
}

@Composable
private fun AddButton(navController: NavHostController) {
    FloatingActionButton(
        containerColor = MaterialTheme.colorScheme.primary,
        onClick = { navController.navigate(AppScreens.AddScreen.route) }
    ) {
        Icon(
            imageVector = Icons.Filled.AddCircle,
            contentDescription = "Add Icon",
            modifier = Modifier
                .padding(24.dp)
                .size(35.dp)
        )
    }
}

@Composable
private fun BodyContent() {

    Text(text = "Text")
    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .padding(top = 100.dp, start = 16.dp, end = 16.dp),
    ){
        item{ Text(text = "Password Manager")}
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview(){
    MainScreen(viewModel = MainViewModel(), navController = NavHostController(LocalContext.current))

}