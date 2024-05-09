package com.example.passwordmanager.ui.screens.add

import android.annotation.SuppressLint
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
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.passwordmanager.navigation.AppScreens


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AddScreen( viewModel: AddViewModel, navController: NavHostController){
    Scaffold (
        topBar = { TopBar(navController) },
        content = { BodyContent() },
        floatingActionButton = { SaveButton() }
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
                text = "Añadir nueva contraseña",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
        },

        navigationIcon = { GoBackButton(navController) }
    )
}

@Composable
private fun SaveButton() {
    FloatingActionButton(
        containerColor = MaterialTheme.colorScheme.primary,
        onClick = { /*TODO*/ }
    ) {
        Icon(
            imageVector = Icons.Filled.Done,
            contentDescription = "Done Icon",
            modifier = Modifier
                .padding(24.dp)
                .size(27.dp)
        )
    }
}
@Composable
fun GoBackButton(navController: NavHostController) {

    Icon(
        imageVector = Icons.Filled.ArrowBack,
        contentDescription ="Arrow Back Icon",

        modifier = Modifier
            .padding(start = 13.dp)
            .size(35.dp)
            .fillMaxWidth()
            .clickable { navController.navigate(AppScreens.MainScreen.route) },
    )
}



@Composable
private fun BodyContent(){

    Column (
        Modifier
            .fillMaxSize()
            .padding(top = 90.dp , start = 10.dp , end = 10.dp)
    )
    {
        TittleField()

        Spacer(modifier = Modifier.padding(15.dp))
        UserAccountField()

        Spacer(modifier = Modifier.padding(15.dp))
        PasswordField()

        Spacer(modifier = Modifier.padding(15.dp))
        TypeAccount()

        Spacer(modifier = Modifier.padding(15.dp))
        NoteField()
    }
}
@Composable
fun NoteField() {
    Column {
        Text(
            text = "Nota:" ,
            fontSize = 15.sp ,
            fontWeight = FontWeight.Bold ,
            textAlign = TextAlign.Center ,
        )

        TextField(
            value = " " ,
            onValueChange = { } ,
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 15.dp, horizontal = 20.dp) ,
            )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TypeAccount() {

    val list = listOf("Tienda" , "Red Social" , "Juegos" , "Personal")
    var selectedText by remember { mutableStateOf(list[0]) }
    var isExpanded by remember { mutableStateOf(false) }


    Row {
        Text(
            text = "Categoria:" ,
            fontSize = 15.sp ,
            fontWeight = FontWeight.Bold ,
            textAlign = TextAlign.Center ,
            modifier = Modifier
                .padding(end = 10.dp)
                .align(Alignment.CenterVertically)
        )

        ExposedDropdownMenuBox(
            expanded = isExpanded ,
            onExpandedChange = {
                isExpanded = !isExpanded
            }) {
            TextField(
                modifier = Modifier.menuAnchor() ,
                value = selectedText ,
                onValueChange = { } ,
                readOnly = true ,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) }
            )

            ExposedDropdownMenu(
                expanded = isExpanded ,
                onDismissRequest = { isExpanded = false }
            ) {
                list.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item) } ,
                        onClick = {
                            selectedText = item
                        }
                    )
                }
            }
        }
    }
}
@Composable
fun PasswordField() {
    Column {
        Text(
            text = "Contraseña:" ,
            fontSize = 15.sp ,
            fontWeight = FontWeight.Bold ,
            textAlign = TextAlign.Center ,
        )

        TextField(
            value = " " ,
            onValueChange = { } ,
            modifier = Modifier.fillMaxWidth() ,
            singleLine = true ,
        )
    }
}

@Composable
fun UserAccountField() {
    Column {
        Text(
            text = "Usuario:" ,
            fontSize = 15.sp ,
            fontWeight = FontWeight.Bold ,
            textAlign = TextAlign.Center ,
        )

        TextField(
            value = " " ,
            onValueChange = { } ,
            modifier = Modifier.fillMaxWidth() ,
            singleLine = true ,
        )
    }
}

@Composable
fun TittleField() {

    Column {
        Text(
            text = "Titulo:" ,
            fontSize = 15.sp ,
            fontWeight = FontWeight.Bold ,
            textAlign = TextAlign.Center ,
        )

        TextField(
            value = " " ,
            onValueChange = { } ,
            modifier = Modifier.fillMaxWidth() ,
            singleLine = true ,
            )
    }
}



