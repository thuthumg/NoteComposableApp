package com.example.notecomposableapp.ui.composables.bookMarksScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BookMarksScreen(modifier: Modifier = Modifier) {
    Column(modifier
        .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 8.dp)
        .fillMaxSize()) {
        LinearNoteListView()
    }

}