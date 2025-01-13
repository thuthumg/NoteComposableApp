package com.example.notecomposableapp.ui.composables


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.notecomposableapp.ui.composables.bookMarksScreen.BookMarksScreen
import com.example.notecomposableapp.ui.composables.createNoteItemScreen.CreateNoteItemView
import com.example.notecomposableapp.ui.composables.homeScreen.HomeScreenView
import com.example.notecomposableapp.ui.theme.ColorPrimary

@Composable
fun BottomNavigationView() {
    // Create a NavController for navigation
    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route
    // MutableState for Home and Bookmarks button selection
    val isHomeSelected = remember { mutableStateOf(false) }
    val isBookmarksSelected = remember { mutableStateOf(false) }
    Scaffold(
        bottomBar = {

            if (currentRoute != "addNote") {

                isHomeSelected.value = true
                isBookmarksSelected.value = false

                CustomButtonBar(
                    modifier = Modifier
                        .fillMaxWidth(),
                    onHomeClick = {
                        isHomeSelected.value = true
                        isBookmarksSelected.value = false
                        navController.navigate("Home")
                    },
                    onBookmarksClick = {
                        isBookmarksSelected.value = true
                        isHomeSelected.value = false
                        navController.navigate("Bookmarks")
                    },
                    onFloatingAction = { navController.navigate("addNote") },
                    isHomeSelected.value,
                    isBookmarksSelected.value

                )
            }
        },
        containerColor = ColorPrimary
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "Home"
        ) {
            composable("Home") { HomeScreen(paddingValues) }
            composable("Bookmarks") { BookmarksScreen(paddingValues) }
            composable("addNote") {
                CreateNoteItemView(
                    onTapBack = {
                        navController.navigateUp()
                    },
                    onSaveClicked = {
                        navController.navigateUp()
                    }
                )
            }
        }
    }

}

@Composable
fun BookmarksScreen(paddingValues: PaddingValues) {
    BookMarksScreen(
        modifier = Modifier
            .padding(paddingValues) // Use padding from Scaffold
            .fillMaxSize()
    )
}

@Composable
fun HomeScreen(paddingValues: PaddingValues) {
    HomeScreenView(
        modifier = Modifier
            .padding(paddingValues) // Use padding from Scaffold
            .fillMaxSize()
    )
}

//@Composable
//fun BottomNavigationBar(modifier: Modifier = Modifier, navController: NavController) {
//    val bottomNavItems = listOf(
//        BottomNavItemData(title = "Home", icon = Icons.Default.Home),
//        BottomNavItemData(title = "BookMarks", icon = Icons.Filled.Bookmark)
//    )
//
//    var selectedValue by remember { mutableStateOf("Home") }
//
//    NavigationBar(
//        // containerColor = BottomNavBarBackgroundColor,
//        modifier = modifier
//    ) {
//        bottomNavItems.forEach { item ->
//            NavigationBarItem(
//                selected = selectedValue == item.title,
//                onClick = {
//                    selectedValue = item.title
//                    navController.navigate(item.title) // Perform navigation
//                },
//                colors = NavigationBarItemDefaults.colors(
//                    selectedIconColor = BottomBarSelectedIconColor,
//                    selectedTextColor = BottomBarSelectedIconColor,
//                    indicatorColor = Color.Transparent,
//                    unselectedIconColor = BottomBarUnSelectedIconColor,
//                    unselectedTextColor = BottomBarUnSelectedIconColor
//                ),
//                icon = { Icon(item.icon, contentDescription = null) },
//                label = { Text(text = item.title) }
//            )
//        }
//    }
//}

// Bottom Nav Item data class
data class BottomNavItemData(val title: String, val icon: ImageVector)

// Preview function
@Preview(showBackground = true)
@Composable
fun BottomNavigationViewPreview() {
    BottomNavigationView()
}