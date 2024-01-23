package com.example.brandnewchat

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.brandnewchat.ui.Navigation
import com.example.brandnewchat.ui.theme.BrandNewChatTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("SecretInSource")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BrandNewChatTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background,
                ) {


                    Navigation()

                }
            }
        }
    }
}
