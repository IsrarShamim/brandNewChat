package com.example.brandnewchat.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.brandnewchat.AppViewModelProvider
import com.example.brandnewchat.ui.chat.ChatScreen
import com.example.brandnewchat.ui.chat.messagesRelistic
import com.example.brandnewchat.ui.screens.NoteApp
import com.example.brandnewchat.ui.screens.SummarizeRoute
import com.example.brandnewchat.ui.screens.SummarizeViewModel


enum class NotesAppScreen(){
    MainScreen,
    ChatScreen,
    ChatScreenTwo
}


@Composable
fun Navigation(
    summarizeViewModel: SummarizeViewModel = viewModel(factory = AppViewModelProvider.Factory),
    navController: NavHostController = rememberNavController()
) {
    Scaffold { innerPaddingValues ->
//        val uiState by summarizeViewModel.uiState.collectAsState()
        NavHost(
            navController = navController,
            startDestination = NotesAppScreen.MainScreen.name,
            modifier = Modifier.padding(innerPaddingValues)
        ) {
            composable(route = NotesAppScreen.MainScreen.name) {
                // Your composable content for the MainScreen
                NoteApp(
//                    summarizeViewModel,
                    onNextButtonClicked = { navController.navigate(NotesAppScreen.ChatScreen.name) },
                    onNextButtonClickedTwo  = { navController.navigate(NotesAppScreen.ChatScreenTwo.name) }
                )
            }
            composable(route= NotesAppScreen.ChatScreen.name){
                SummarizeRoute(summarizeViewModel)
            }
            composable(route =  NotesAppScreen.ChatScreenTwo.name){
                    ChatScreen(
                        summarizeViewModel,
                        messages = messagesRelistic) {

                    }
            }
        }
    }
}

