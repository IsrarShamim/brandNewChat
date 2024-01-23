package com.example.brandnewchat.data.Repository

import com.example.brandnewchat.data.Dao.ChatDao
import com.example.brandnewchat.data.Entity.Chat
import kotlinx.coroutines.flow.Flow


/**
 * Repository that provides insert, update, delete, and retrieve of [Item] from a given data source.
 */
interface ChatRepository {
    /**
     * Retrieve all the items from the given data source.
     */
    fun getAllItemsStream(): Flow<List<Chat>>

    /**
     * Retrieve an item from the given data source that matches with the [id].
     */
    fun getItemStream(id: Int): Flow<Chat?>

    /**
     * Insert item in the data source
     */
    suspend fun insertItem(chat: Chat)

    /**
     * Delete item from the data source
     */
    suspend fun deleteItem(chat: Chat)

    /**
     * Update item in the data source
     */
    suspend fun updateItem(chat: Chat)
}
class onlineChatRepository(private val chatDao: ChatDao) : ChatRepository {

    override fun getAllItemsStream(): Flow<List<Chat>> = chatDao.getAllChats()

    override fun getItemStream(id: Int): Flow<Chat?> = chatDao.select(id)

    override suspend fun insertItem(chat: Chat) = chatDao.insertChat(chat)

    override suspend fun deleteItem(chat: Chat) = chatDao.delete(chat)

    override suspend fun updateItem(chat: Chat) = chatDao.updateChat(chat)
}