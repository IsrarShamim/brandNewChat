package com.example.brandnewchat.network

import com.google.ai.client.generativeai.GenerativeModel


class SummarizeNetwork() {
    private val generativeModel: GenerativeModel = GenerativeModel( "gemini-pro","AIzaSyAraixqkLku2TBDJA8Ps5gtNv-MkOnTJNI")
    suspend fun generateContent(prompt: String): String? {
        // You would typically make a network call or perform data operations here
        // For simplicity, let's assume ContentResponse is a placeholder data class
        val response = generativeModel.generateContent(prompt)
        var returnResponse :String? = ""
        response.text?.let { outputContent ->
            returnResponse = outputContent

        }
        return returnResponse
    }
}
//class SummarizeRepository : ChatRepository {
//    override fun getAllItemsStream(): Flow<List<Chat>> = itemDao.getAllItems()
//
//    override fun getItemStream(id: Int): Flow<Item?> = itemDao.getItem(id)
//
//    override suspend fun insertItem(item: Item) = itemDao.insert(item)
//
//    override suspend fun deleteItem(item: Item) = itemDao.delete(item)
//
//    override suspend fun updateItem(item: Item) = itemDao.update(item)
//
//
//
//
//}