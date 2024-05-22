package com.example.passwordmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.room.Room
import com.example.passwordmanager.data.item.ItemsDatabase
import com.example.passwordmanager.data.item.ItemsViewModel
import com.example.passwordmanager.navigation.AppNavigation
import com.example.passwordmanager.ui.theme.PasswordManagerTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PasswordManagerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    val database = Room.databaseBuilder(this, ItemsDatabase::class.java, "db_items").build()
                    val itemDao = database.itemsDao()
                    val viewModel = ItemsViewModel(itemDao)
                    AppNavigation(viewModel = viewModel)
                }
            }
        }
    }
}

