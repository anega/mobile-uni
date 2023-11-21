package com.example.lab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.lab2.screens.MainAppScreen
import com.example.lab2.ui.theme.Lab2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab2Theme {
                MainAppScreen()
            }
        }
    }
}
