package com.example.notecomposableapp.ui.custom

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notecomposableapp.ui.theme.BottomBarSelectedIconColor
import com.example.notecomposableapp.ui.theme.BottomBarUnSelectedIconColor

@Composable
fun CustomBottomNavigation(
    currentScreenId: String,
    onItemSelected: (Screen) -> Unit,
    onFloatingAction:() -> Unit
) {
    val items = Screen.Items.list

    Row(
        modifier = Modifier
            .background(
                MaterialTheme.colorScheme.background
            )
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ) {
        items.forEach { item ->
            CustomBottomNavigationItem(item= item, isSelected = item.id == currentScreenId){
                onItemSelected(item)
            }
            Spacer(modifier = Modifier.width(20.dp))
        }

        Box(modifier = Modifier.weight(1f)) {
            FloatingActionButton(
                modifier = Modifier.align(Alignment.BottomEnd),
                shape = RoundedCornerShape(30.dp),
                containerColor = MaterialTheme.colorScheme.secondary,
                onClick = onFloatingAction,
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "fab icon")
            }
        }
    }
}

@Composable
fun CustomBottomNavigationItem(
    item: Screen, isSelected: Boolean, onClick: () -> Unit
) {
    val background = BottomBarSelectedIconColor
        //if (isSelected) MaterialTheme.colorScheme.primary.copy(alpha = 0.1f) else Color.Transparent
    val contentColor =
        if (isSelected) Color.White else BottomBarUnSelectedIconColor
        //MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onBackground

    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(background)
            .clickable(onClick = onClick)
    ) {

        Row(
            modifier = Modifier
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                imageVector = item.icon,
                contentDescription = null,
                tint = contentColor
            )
            AnimatedVisibility(
                visible = isSelected
            ) {
                Text(
                    text = item.title,
                    color = contentColor
                )
            }
        }


    }
}


// Preview function
@Preview(showBackground = true)
@Composable
fun CustomBottomNavigationPreview() {
    CustomBottomNavigation(currentScreenId = "", onItemSelected = {}, onFloatingAction = {})
}