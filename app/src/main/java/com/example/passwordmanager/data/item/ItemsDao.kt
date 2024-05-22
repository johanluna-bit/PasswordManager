package com.example.passwordmanager.data.item

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemsDao {

    @Query("SELECT * FROM items_table")
    fun getAllItems(): Flow<List<Items>>

    @Query("SELECT * FROM items_table WHERE id = :id")
    fun getItem(id: Int): Flow<Items>

    @Insert
    suspend fun insert(item: Items)

    @Update
    suspend fun update(item: Items)

    @Delete
    suspend fun delete(item: Items)

}