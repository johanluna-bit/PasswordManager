package com.example.passwordmanager.ui.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.passwordmanager.data.item.ItemsViewModel
import com.example.passwordmanager.navigation.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController, viewModel: ItemsViewModel){

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Password Manager", color = Color.White, fontWeight = FontWeight.Bold)
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor =MaterialTheme.colorScheme.primary,
                )
            )
        },

        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate( AppScreens.AddScreen.route) },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White
            ) {
                Icon(imageVector = Icons.Default.Add , contentDescription = "Agregar")
            }
        }

        ){
        ContentMainScreen(it, navController, viewModel)

    }
}

@Composable
fun ContentMainScreen(it: PaddingValues , navController: NavController , viewModel: ItemsViewModel){

    val state = viewModel.state

    Column ( modifier = Modifier.padding(it)){
        LazyColumn {
            items(state.listItems){
               Box (
                   modifier = Modifier
                       .padding(8.dp)
                       .fillMaxWidth()
               ) {
                   Column(modifier = Modifier.padding(12.dp))
                   {
                       Text(text = it.tittle.toString())
                       Text(text = it.email.toString())
                       Text(text = it.password.toString())
                       Text(text = it.typeAccount.toString())
                       Text(text = it.description.toString())

                       //Boton Editar---------------------------------------------------------------
                       IconButton(
                           onClick = { navController.navigate("edit_screen/${it.id}/${it.tittle}/${it.email}/${it.password}/${it.typeAccount}/${it.description}") }
                       ) {
                           Icon(imageVector = Icons.Default.Edit , contentDescription = "Editar")
                       }

                       //Boton Eliminar-------------------------------------------------------------
                       IconButton(
                           onClick = { viewModel.deleteItem(it) }
                       ) {
                           Icon(
                               imageVector = Icons.Default.Delete ,
                               contentDescription = "Eliminar"
                           )
                       }
                   }
               }
            }
        }
    }
}
