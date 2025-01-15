package com.example.notecomposableapp.ui.custom

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val id : String,
    val title : String,
    val icon : ImageVector
) {
    data object Home : Screen("home", "Home", Icons.Default.Home)
    data object BookMarks : Screen("bookMarks","Bookmarks", Icons.Default.Bookmark)

    object Items{
        val list = listOf(
            Home, BookMarks
        )
    }
}