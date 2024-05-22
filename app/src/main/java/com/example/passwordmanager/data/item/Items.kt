package com.example.passwordmanager.data.item

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items_table")
data class Items(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0 ,

    @ColumnInfo(name = "tittle")
    val tittle: String? = null ,

    @ColumnInfo(name = "email")
    val email: String? = null ,

    @ColumnInfo(name = "password")
    val password: String? = null ,

    @ColumnInfo(name = "typeAccount")
    val typeAccount: String? = null ,

    @ColumnInfo(name = "description")
    val description: String? = null ,

    )
