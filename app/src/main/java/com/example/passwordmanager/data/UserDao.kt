package com.example.passwordmanager.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Insert (onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    suspend fun getAllUsers(): LiveData<User>

//    @Query("SELECT * FROM user_table WHERE user_id = :userId")
//    suspend fun getUserById(userId: Int): User?
//
//
//    @Query("DELETE FROM user_table WHERE user_id = :userId")
//    suspend fun deleteUserById(userId: Int)
//
//
//    @Query("UPDATE user_table SET email = :newEmail WHERE user_id = :userId")
//    suspend fun updateUser(userId: Int, newEmail: String)

}