package com.example.notecomposableapp.ui.composables

import android.util.Log
import android.view.View
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.notecomposableapp.ui.theme.BottomBarBGColor
import com.example.notecomposableapp.ui.theme.BottomBarSelectedIconColor
import com.example.notecomposableapp.ui.theme.BottomBarUnSelectedIconColor

@Composable
fun CustomButtonBar(
    modifier: Modifier = Modifier,
    onHomeClick: () -> Unit,
    onBookmarksClick: () -> Unit,
    onFloatingAction: () -> Unit,
    isHomeSelected: Boolean,
    isBookMarkSelected: Boolean
) {
    Log.d("CustomButtonBar","isHomeSelected $isHomeSelected --------- isBookMarkSelected $isBookMarkSelected")
    Row(
        modifier = modifier
            .windowInsetsPadding(WindowInsets.systemBars)
            .background(BottomBarBGColor)
            .padding(horizontal = 16.dp, vertical = 12.dp), // Custom padding for the bar
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Home Button
        OutlinedButton(
            onClick = {
                onHomeClick()
            },
            colors = ButtonDefaults.outlinedButtonColors(
                 contentColor = if (isHomeSelected) Color.White else BottomBarUnSelectedIconColor,
                containerColor = BottomBarSelectedIconColor
            ),
            border = BorderStroke(width = 1.dp, color = BottomBarSelectedIconColor),
            shape = RoundedCornerShape(8.dp)
        ) {
            Row {
                Text(
                    "Home",
                   // color = if (isHomeSelected) Color.White else BottomBarUnSelectedIconColor
                )
                Icon(
                    Icons.Filled.Home,
                    contentDescription = null,
                    tint = if (isHomeSelected) Color.White else BottomBarUnSelectedIconColor
                )
            }
        }

        Spacer(modifier = Modifier.width(20.dp))
        // Bookmarks Button

        OutlinedButton(
            onClick = {
                onBookmarksClick()
            },
            colors = ButtonDefaults.outlinedButtonColors(
                 contentColor = if (isBookMarkSelected) Color.White else BottomBarUnSelectedIconColor,
                containerColor = BottomBarSelectedIconColor
            ),
            border = BorderStroke(width = 1.dp, color = BottomBarSelectedIconColor),
            shape = RoundedCornerShape(8.dp)
        ) {
            Row {
                Text(
                    "BookMarks",
                   // color = if (isBookmarksSelected) Color.White else BottomBarUnSelectedIconColor
                )
                Icon(
                    Icons.Filled.Bookmark,
                    contentDescription = null,
                    tint = if (isBookMarkSelected) Color.White else BottomBarUnSelectedIconColor
                )
            }
        }
        Box(modifier = Modifier.weight(1f)) {
            FloatingActionButton(
                modifier = Modifier.align(Alignment.BottomEnd),
                shape = RoundedCornerShape(30.dp),
                containerColor = MaterialTheme.colorScheme.primary,
                onClick = onFloatingAction,
                //  modifier = Modifier.offset(y = (-30).dp) // Move FAB up to overlap the custom bar
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "fab icon")
            }
        }

    }
}

@Preview
@Composable
private fun CustomButtonBarPreView() {
    CustomButtonBar(onHomeClick = { }, onFloatingAction = {}, onBookmarksClick = {},isHomeSelected = false, isBookMarkSelected = false)
}