package com.example.brandnewchat

import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.brandnewchat.network.SummarizeNetwork
import com.example.brandnewchat.ui.screens.SummarizeViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        // Initializer for ItemEditViewModel
        initializer {
            SummarizeViewModel(
                SummarizeNetwork(),
                ChatApplication().container.chatRepository
            )
        }
//        // Initializer for ItemEntryViewModel
//        initializer {
//            ItemEntryViewModel(inventoryApplication().container.itemsRepository)
//        }
//
//        // Initializer for ItemDetailsViewModel
//        initializer {
//            ItemDetailsViewModel(
//                this.createSavedStateHandle()
//            )
//        }
//
//        // Initializer for HomeViewModel
//        initializer {
//            HomeViewModel()
//        }
    }
}