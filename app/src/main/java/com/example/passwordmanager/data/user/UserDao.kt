package com.example.passwordmanager.data.user

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface UserDao {

    @Insert (onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<User>>

}




















//    @Insert (onConflict = OnConflictStrategy.IGNORE)
//    suspend fun insertUser(user: User)
//    @Delete
//    suspend fun deleteUser(user: User)
//    @Query("SELECT * FROM user_table ORDER BY id ASC")
//    suspend fun getAllUsers(): LiveData<User>
//
//    @Query (" SELECT * FROM user_table ORDER BY id DESC")
//    fun getUsersByOrderAdd () : Flow<List<User>>