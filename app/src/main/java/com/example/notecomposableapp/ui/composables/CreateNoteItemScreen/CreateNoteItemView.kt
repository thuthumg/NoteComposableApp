package com.example.notecomposableapp.ui.composables.createNoteItemScreen


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

//@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateNoteItemView(
    onTapBack: () -> Unit,
    onSaveClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    // State to hold the text input value
    var titleText by remember { mutableStateOf("") }
    var descText by remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            CustomAppBar(
                onTapBack = onTapBack,
                showNavigationIcon = true,
                showSaveButton = true,
                onSaveClicked = onSaveClicked)
        }, modifier = modifier
    ) { paddingValues ->

        Column(modifier = Modifier.padding(paddingValues)) {
//
//            val textFieldFocusRequester = remember { FocusRequester() }
//
//            // Automatically request focus when the screen opens
//            LaunchedEffect(Unit) {
//                textFieldFocusRequester.requestFocus()
//            }
//            TextField(
//                value = descText,
//                onValueChange = { newText ->
//                    descText = newText
//                },
//                textStyle = TextStyle(
//                fontSize = 16.sp),
////                colors = TextFieldDefaults.textFieldColors(
////                    containerColor = Color.Transparent, // Set your desired background color
////                    focusedIndicatorColor = Color.Transparent, // Remove underline when focused
////                    unfocusedIndicatorColor = Color.Transparent, // Remove underline when unfocused
////                    // focusedPlaceholderColor = NoteTextColor,
////                    // unfocusedPlaceholderColor = NoteTextColor,
////                    focusedTextColor = Color.White
////                ),
//                modifier = Modifier
//                    .focusRequester(textFieldFocusRequester)
//            )
        }
    }
}

// Preview function
@Preview(showBackground = true)
@Composable
fun CreateNoteItemViewPreview() {
    CreateNoteItemView(onTapBack = {}, onSaveClicked = {})
}