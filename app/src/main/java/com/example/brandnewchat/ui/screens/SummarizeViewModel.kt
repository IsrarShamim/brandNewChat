package com.example.brandnewchat.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.brandnewchat.SummarizeUiState
import com.example.brandnewchat.data.Entity.Chat
import com.example.brandnewchat.data.Entity.Message
import com.example.brandnewchat.data.Repository.ChatRepository
import com.example.brandnewchat.network.SummarizeNetwork
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class SummarizeViewModel(
    private val repository: SummarizeNetwork,
    private val chatsRepository: ChatRepository

) : ViewModel() {

    private val _uiState: MutableStateFlow<SummarizeUiState> =
        MutableStateFlow(SummarizeUiState.Initial)
    val uiState: StateFlow<SummarizeUiState> =
        _uiState.asStateFlow()

    fun update(userInput: String,
           ) {
        viewModelScope.launch {
            val recieveResponse = summarize(userInput)

            val joinedMessage = Message(userInput, recieveResponse.toString())
            chatsRepository.insertItem(Chat(0,joinedMessage))
        }
    }
    fun summarize(inputText: String): String? {
        _uiState.value = SummarizeUiState.Loading

        val prompt = "Summarize the following text for me: $inputText"
        var returnResponse: String? = ""

        viewModelScope.launch {
            try {
                returnResponse = repository.generateContent(prompt)


            } catch (e: Exception) {
                _uiState.value = SummarizeUiState.Error(e.localizedMessage ?: "")
            }
        }

        return returnResponse
    }
}