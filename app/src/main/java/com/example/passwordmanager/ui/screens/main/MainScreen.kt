package com.example.passwordmanager.ui.screens.main


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
        content = { BodyContent(viewModel, navController)},
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
private fun BodyContent(viewModel: MainViewModel , navController: NavHostController) {


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp , start = 16.dp , end = 16.dp),
    ){
        item{
            ItemOfLazyColumn(navController)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview(){
    MainScreen(viewModel = MainViewModel(), navController = NavHostController(LocalContext.current))

}


@Composable
fun ItemOfLazyColumn( navController: NavHostController) {

    var tittle by remember { mutableStateOf(" Item 1 ") }
    var showDialog by rememberSaveable { mutableStateOf(false) }

    Column(
        Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.primaryContainer)

    ){
        Row(

            Modifier.fillMaxWidth()){
            Text(
                text = tittle,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .align(Alignment.CenterVertically)
            )

            Spacer(modifier = Modifier.weight(1f))
            IconButton(
                onClick = { showDialog = true  }
            ) {
                Image(imageVector = Icons.Filled.MoreVert, contentDescription ="OptionButton")
                Modifier
                    .fillMaxWidth()
                    .size(70.dp)
            }
        }
    }


    if(showDialog){
        AlertDialog(
            onDismissRequest = { showDialog = false } ,

            confirmButton = {
                TextButton(
                    onClick = {
                        showDialog = false
                        navController.navigate(AppScreens.AddScreen.route)
                    }
                ){
                    Text(text = "Editar")
                }
            },

            dismissButton = {
                TextButton(
                    onClick = { showDialog = false }
                ) {
                    Text(text = "Eliminar")
                }},

            title = { Text(text = "¿Qué deseas hacer?") },
        )
    }
}
