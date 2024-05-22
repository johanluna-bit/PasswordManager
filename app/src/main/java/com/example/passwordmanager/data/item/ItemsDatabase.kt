package com.example.passwordmanager.data.item

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.passwordmanager.data.user.UserDatabase
import kotlinx.coroutines.InternalCoroutinesApi

@Database(
    entities = [Items::class],
    version = 1,
    exportSchema = false
)
abstract class ItemsDatabase: RoomDatabase(){

    abstract fun itemsDao(): ItemsDao

    companion object{
        @Volatile
        private var INSTANCE: ItemsDatabase?= null

        @OptIn(InternalCoroutinesApi::class)
        fun getDatabase(context: Context): ItemsDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            kotlinx.coroutines.internal.synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext ,
                    ItemsDatabase::class.java ,
                    "user_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}
