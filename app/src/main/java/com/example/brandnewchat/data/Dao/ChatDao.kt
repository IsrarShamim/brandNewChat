package com.example.brandnewchat.data.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.brandnewchat.data.Entity.Chat
import kotlinx.coroutines.flow.Flow


@Dao
interface ChatDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertChat(chat:Chat)

    @Update
    suspend fun updateChat(chat:Chat)

    @Delete
    suspend fun delete(chat: Chat)

    @Query("SELECT * from chats WHERE id = :id")
    fun select(id :Int): Flow<Chat>

    @Query("SELECT * FROM chats ORDER BY id DESC")
    fun getAllChats(): Flow<List<Chat>>




}