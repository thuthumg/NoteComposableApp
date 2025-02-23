package com.example.notecomposableapp.ui.composables

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LinearNoteListView(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(30, key = {it}){
            NoteItemView()
        }

    }
}

// Preview function
@Preview(showBackground = true)
@Composable
fun LinearNoteListViewPreview() {
    LinearNoteListView()
}