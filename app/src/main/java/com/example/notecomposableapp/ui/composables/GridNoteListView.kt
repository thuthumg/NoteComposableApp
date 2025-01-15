package com.example.notecomposableapp.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.ceil

@Composable
fun GridNoteListView(modifier: Modifier = Modifier) {

    val gridHeight = (ceil(30.toDouble() / 2).toInt() * 56).dp

    LazyVerticalGrid(
    columns = GridCells.Fixed(2),
    modifier = modifier.height(gridHeight),
    horizontalArrangement = Arrangement.spacedBy(2.dp),
    //verticalArrangement = Arrangement.spacedBy(2.dp)
    )
     {
        items(30){
            NoteItemView()
        }
    }
}

// Preview function
@Preview(showBackground = true)
@Composable
fun GridNoteListViewPreview() {
    GridNoteListView()
}