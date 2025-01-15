package com.example.notecomposableapp.ui.custom

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost

import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.notecomposableapp.ui.composables.CreateNoteItemView
import com.example.notecomposableapp.ui.screen.BookMarksScreen
import com.example.notecomposableapp.ui.screen.HomeScreen

@Composable
fun Navigation(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.id
    ) {
        composable(Screen.Home.id) {
            HomeScreen(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            )
        }
        composable(Screen.BookMarks.id) {
            BookMarksScreen(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            )
        }

        composable("AddNote"){
            CreateNoteItemView(onTapBack = {
                navController.navigateUp()
            }, onSaveClicked = {}, modifier = Modifier)
        }

    }
}