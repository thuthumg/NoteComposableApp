package com.example.notecomposableapp.ui.composables.bookMarksScreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.notecomposableapp.ui.composables.NoteItemView

@Composable
fun BookMarksNoteItemListView(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(30, key = {it}){
            NoteItemView()
        }

    }
}

// Preview function
@Preview(showBackground = true)
@Composable
fun BookMarksNoteItemListViewPreview() {
    BookMarksNoteItemListView()
}