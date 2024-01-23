package com.example.brandnewchat

import android.app.Application
import com.example.brandnewchat.data.appContainer.AppDataContainer

class ChatApplication :Application() {
//       lateinit var container: AppContainer
    val container by lazy {
        AppDataContainer(this)
    }
//            init {
//    container = AppDataContainer(this)
//}

    override fun onCreate() {
        super.onCreate()
//        container = AppDataContainer(this)
    }
}