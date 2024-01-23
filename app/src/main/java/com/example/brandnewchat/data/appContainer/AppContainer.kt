package com.example.brandnewchat.data.appContainer

import android.content.Context
import android.util.Log
import com.example.brandnewchat.data.DataBase.ChatDatabase
import com.example.brandnewchat.data.Repository.ChatRepository
import com.example.brandnewchat.data.Repository.onlineChatRepository

/**
 * App container for Dependency injection.
 */
interface AppContainer {
    val chatRepository: ChatRepository
}

/**
 * [AppContainer] implementation that provides instance of [OfflineItemsRepository]
 */
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementation for [ItemsRepository]
     */

    override val chatRepository: ChatRepository by lazy {
        Log.d("debuggingpro", "apdatacontainerentered context: ${context}")

        onlineChatRepository(ChatDatabase.getDatabase(context).chatDao())
    }
}