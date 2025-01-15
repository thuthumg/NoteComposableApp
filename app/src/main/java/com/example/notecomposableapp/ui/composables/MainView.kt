package com.example.notecomposableapp.ui.composables


import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
//import com.example.notecomposableapp.ui.composables.createNoteItemScreen.CreateNoteItemView
import com.example.notecomposableapp.ui.custom.CustomBottomNavigation
import com.example.notecomposableapp.ui.custom.Navigation
import com.example.notecomposableapp.ui.custom.Screen
import com.example.notecomposableapp.ui.theme.ColorPrimary

@Composable
fun MainView() {

    val currentScreen = remember{
        mutableStateOf<Screen>(Screen.Home)}
    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    var showExitDialog by remember {
        mutableStateOf(false)
    }
    // Observe the NavController's current destination
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    // Update the current screen based on the destination
    LaunchedEffect(navBackStackEntry) {
        navBackStackEntry?.destination?.route?.let { route ->
            val matchingScreen = Screen.Items.list.find { it.id == route }
            if (matchingScreen != null) {
                currentScreen.value = matchingScreen
            }
        }
    }

    BackHandler(enabled = true) {
        // Show exit dialog if on the home screen
        if (currentScreen.value.id == Screen.Home.id) {
            showExitDialog = true
        } else {
            navController.popBackStack() // Go back to the previous screen
        }
    }

    Scaffold(
        bottomBar = {

            if (currentRoute != "addNote") {
                CustomBottomNavigation(
                    currentScreenId = currentScreen.value.id,
                    onItemSelected = { selectedScreen ->
                        currentScreen.value = selectedScreen
                        navController.navigate(selectedScreen.id)
                        {
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }},
                    onFloatingAction = {})

            }
        },
        containerColor = ColorPrimary
    ) { paddingValues ->

        Navigation(navController = navController,paddingValues)

        if(showExitDialog){
            val activity = LocalContext.current as? Activity
            AlertDialog(
                onDismissRequest = { },
                title = { Text("Exit App") },
                text = { Text("Are you sure you want to exit the app?") },
                confirmButton = {
                    Button(onClick = { activity?.finish() }) {
                        Text("Yes")
                    }
                },
                dismissButton = {
                    Button(onClick = { showExitDialog = false }) {
                        Text("No")
                    }
                }
            )
        }
    }

}

// Preview function
@Preview(showBackground = true)
@Composable
fun MainViewPreview() {
    MainView()
}