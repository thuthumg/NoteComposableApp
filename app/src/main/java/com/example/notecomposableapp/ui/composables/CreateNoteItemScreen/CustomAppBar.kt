package com.example.notecomposableapp.ui.composables.createNoteItemScreen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.notecomposableapp.ui.theme.ColorPrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomAppBar(
    onTapBack: () -> Unit,
    showNavigationIcon: Boolean,
    showSaveButton: Boolean,
    onSaveClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    var titleText by remember { mutableStateOf("") }
    TopAppBar(
        title = {
            TextField(
                value = titleText,
                onValueChange = { newText ->
                    titleText = newText
                },
                placeholder = { Text("Enter title") },
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent, // Set your desired background color
                    focusedIndicatorColor = Color.Transparent, // Remove underline when focused
                    unfocusedIndicatorColor = Color.Transparent, // Remove underline when unfocused
                   // focusedPlaceholderColor = NoteTextColor,
                   // unfocusedPlaceholderColor = NoteTextColor,
                    focusedTextColor = MaterialTheme.colorScheme.primary
                ),
                modifier = Modifier.fillMaxWidth()
            )
        },
        navigationIcon = {
            if (showNavigationIcon) {
                IconButton(onClick = onTapBack) {
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null,
                        tint = Color.White
                    )

                }
            }
        },
        actions = {


            if (showSaveButton) {
                IconButton(onClick = onSaveClicked) {
                    Icon(
                        Icons.Default.Save,
                        contentDescription = "Save",
                        tint = MaterialTheme.colorScheme.onSurface
                    )

                }
            }

        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = ColorPrimary
        ),
        modifier = modifier
    )
}