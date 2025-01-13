package com.example.notecomposableapp.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkAdd
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notecomposableapp.ui.theme.CardBGColor
import com.example.notecomposableapp.ui.theme.NoteDescTextColor
import com.example.notecomposableapp.ui.theme.TitleTextColor

@Composable
fun NoteItemView(modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .padding( start = 4.dp, end = 2.dp, top = 4.dp, bottom = 2.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = CardBGColor // Set the background color
        ),
        elevation = CardDefaults.cardElevation()
    ) {
        Column(modifier = modifier.padding(8.dp)) {
            Text(
                text = "Title Text",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = TitleTextColor
            )
            Text(
                text = "Description Text",
                fontSize = 12.sp,
                color = NoteDescTextColor
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = "Delete Icon",
                    tint =  Color(0xFFFFFF8E1)
                )
                Icon(
                    imageVector = Icons.Filled.BookmarkAdd,
                    contentDescription = "Bookmark Icon",
                    tint =  Color(0xFFFFFF8E1)
                )
            }
        }
    }
}

// Preview function
@Preview(showBackground = true)
@Composable
fun NoteItemViewPreview() {
    NoteItemView()
}