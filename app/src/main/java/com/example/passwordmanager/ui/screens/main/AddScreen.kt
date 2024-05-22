package com.example.passwordmanager.ui.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.passwordmanager.data.item.Items
import com.example.passwordmanager.data.item.ItemsViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddScreen (navController: NavController, viewModel: ItemsViewModel) {

    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Agregar Nota" , color = Color.White , fontWeight = FontWeight.Bold)
                } ,
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary ,
                ) ,

                navigationIcon = {
                    IconButton(
                        onClick = { navController.popBackStack() }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack ,
                            contentDescription = "Regresar" ,
                            tint = Color.White
                        )
                    }
                }
            )
        }
    ) {
        ContentAddScreen(it, navController, viewModel)
    }
}

@Composable
fun ContentAddScreen(it: PaddingValues , navController: NavController , viewModel: ItemsViewModel){
    var tittle by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var typeAccount by remember { mutableStateOf("") }
    var note by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(it)
            .padding(top = 30.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        //INPUTS------------------------------------------------------------------------------------

        //TITULO-------------------------------
        OutlinedTextField(
            label = { Text(text = "Titulo") } ,
            value = tittle,
            onValueChange ={ tittle = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )

        //Email-------------------------------
        OutlinedTextField(
            label = { Text(text = "Email") } ,
            value = email,
            onValueChange ={ email = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )

        //Password-------------------------------
        OutlinedTextField(
            label = { Text(text = "Contraseña") } ,
            value = password,
            onValueChange ={ password = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )

        //Tipo de cuenta-------------------------------

        OutlinedTextField(
            label = { Text(text = "Tipo de cuenta") } ,
            value = typeAccount,
            onValueChange ={ typeAccount = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )

        //Nota-------------------------------
        OutlinedTextField(
            label = { Text(text = "Nota") } ,
            value = note,
            onValueChange ={ note = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )

        //BOTON-------------------------------
        Button(
            onClick = {
                val item = Items(
                    tittle = tittle,
                    email = email,
                    password = password,
                    typeAccount = typeAccount,
                    description = note
                )
                viewModel.addItem(item)
                navController.popBackStack()
            }
        ) {
            Text(text = "Guardar")
        }
    }
}