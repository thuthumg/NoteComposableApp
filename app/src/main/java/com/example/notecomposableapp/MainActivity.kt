package com.example.notecomposableapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.notecomposableapp.ui.composables.MainView
import com.example.notecomposableapp.ui.theme.NoteComposableAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NoteComposableAppTheme {
                MainView()
            }
        }
    }
}
