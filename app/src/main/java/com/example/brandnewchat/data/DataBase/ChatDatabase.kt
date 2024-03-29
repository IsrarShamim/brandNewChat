package com.example.brandnewchat.data.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.brandnewchat.data.Dao.ChatDao
import com.example.brandnewchat.data.Entity.Chat


@Database(entities = [Chat::class], version = 1, exportSchema = false)
abstract class ChatDatabase: RoomDatabase() {

    abstract fun chatDao():ChatDao

    companion object {
        @Volatile
        private var INSTANCE: ChatDatabase? = null
        fun getDatabase(context: Context): ChatDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ChatDatabase::class.java,
                    "chat_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }



}
