package com.example.notecomposableapp.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notecomposableapp.ui.composables.GridNoteListView
import com.example.notecomposableapp.ui.custom.CustomSearchBox
import com.example.notecomposableapp.ui.theme.TitleTextColor

@Composable
fun HomeScreen(modifier: Modifier) {
    var searchQuery by remember { mutableStateOf("") }
    Column(modifier
        .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 8.dp)
        .fillMaxSize()) {

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Notes",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = TitleTextColor
        )

        Spacer(modifier = Modifier.height(8.dp))

        CustomSearchBox(
            query = searchQuery,
            onQueryChanged = { newQuery -> searchQuery = newQuery }
        )

        Spacer(modifier = Modifier.height(8.dp))

        GridNoteListView()
    }
}

// Preview function
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(modifier = Modifier)
}