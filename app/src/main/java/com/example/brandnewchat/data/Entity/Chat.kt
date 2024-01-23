package com.example.brandnewchat.data.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey
data class Message(
    val sender: String,
    val text: String
)
@Entity(tableName = "chats")
data class Chat(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0 ,

    val userResponse : Message,
//
//    val aiResponse : Message,
)
