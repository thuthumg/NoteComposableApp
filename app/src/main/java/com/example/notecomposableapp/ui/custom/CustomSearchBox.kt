package com.example.notecomposableapp.ui.custom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notecomposableapp.ui.theme.SearchBoxBGColor

@Composable
fun CustomSearchBox(
    query: String,
    onQueryChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    BasicTextField(
        value = query,
        onValueChange = onQueryChanged,
        textStyle = TextStyle(
            fontSize = 16.sp,
            color = Color.White
        ),
        cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
        modifier = modifier
            .fillMaxWidth(0.9f)
            .height(50.dp)
            .background(
                color = SearchBoxBGColor,
                shape = RoundedCornerShape(30.dp)
            )
            .padding(horizontal = 16.dp, vertical = 12.dp),
        decorationBox = { innerTextField ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxSize()
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon",
                    tint = Color.White,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Box(
                    modifier = Modifier
                        .weight(1f) // Allow the text field to take up remaining space
                        .align(Alignment.CenterVertically) // Align vertically for better positioning
                ) {
                    if (query.isEmpty()) {
                        Text(
                            text = "Search...",
                            fontSize = 16.sp,
                            color = Color.Gray
                        )
                    }
                    innerTextField() // This renders the actual input text, with cursor handling
                }
            }
        }
    )

}

@Preview
@Composable
private fun CustomSearchBoxPreview() {
    CustomSearchBox(query = "", onQueryChanged = {})
}