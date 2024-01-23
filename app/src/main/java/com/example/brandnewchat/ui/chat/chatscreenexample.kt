package com.example.brandnewchat.ui.chat

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.brandnewchat.ui.screens.SummarizeViewModel


@Composable
fun ChatScreen(
    summarizeViewModel: SummarizeViewModel ,
    messages: List<Message>,
    onMessageSent: (String) -> Unit
) {

    // Create a mutable state list to store the messages
    val newMessages = remember { mutableStateListOf<Message>() }


    // Create a mutable state to store the current message being typed
    val messageText = remember { mutableStateOf("") }
    Column(Modifier.fillMaxSize()) {
        LazyColumn(Modifier.weight(1f)) {
            item {
                messages.forEach() {
                    MessageItem(message = it)
                    Log.d("debugginpro","in lazycolumn entered, this should be 10 times, ")

                }
            }
        }
        newMessages.forEachIndexed { index, message ->
            Log.d("debugginpro", "CHATSCREEN entered  " +
                    "message $index = ${newMessages[index]}")
        }


        TextField(
            value = messageText.value,
            onValueChange = {messageText.value = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            placeholder = { Text("Type a message") },
            trailingIcon = {
                IconButton(onClick = {

                   summarizeViewModel.update(messageText.value)


                    // Send message
                    newMessages.add(Message("User", messageText.value))
                    messageText.value = ""
                    newMessages.forEachIndexed { index, message ->
                        Log.d("debugginpro", "textfield AFTER .add entered  " +
                                "message $index = ${newMessages[index].text}")
                    }


                }) {
                    Icon(imageVector = Icons.AutoMirrored.Filled.Send, contentDescription = "Send message")
                }
            }
        )
    }
}

@Composable
private fun MessageItem(message: Message) {
    val isFromUser = message.sender == "User"
    val backgroundColor = if (isFromUser) Color.Blue else Color.Gray
    val textColor = if (isFromUser) Color.White else Color.Black


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = if (isFromUser) Arrangement.End else Arrangement.Start
    ) {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .background(
                    backgroundColor, shape = RoundedCornerShape(
                        topStart = 48f,
                        topEnd = 48f,
                        bottomStart = if (isFromUser) 48f else 0f,
                        bottomEnd = if (isFromUser) 0f else 48f
                    )
                )
        ) {
            Text(
                text = message.text,
                color = textColor,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

data class Message(
    val sender: String,
    val text: String
)
val messagesRelistic=

    mutableStateListOf(
        Message("User", "Hello, how are you?"),
        Message("Received", "I'm doing well, thanks. How are you?"),
        Message("User", "I'm doing great, thanks."),
        Message("Received", "That's good to hear."),
        Message("User", "What are you up to today?"),
        Message("Received", "I'm working on a new project."),
        Message("User", "That sounds interesting. What is it about?"),
        Message("Received", "It's a new app that will help people learn new languages."),
        Message("User", "That sounds really useful. I'd love to try it out."),
        Message("Received", "I'll let you know when it's ready.")
    )
//
//@Preview
//@Composable
//fun hshs(){
//    BrandNewChatTheme{
////        ChatScreen(messages = messagesRelistic) {
//
//        }
//    }
//}