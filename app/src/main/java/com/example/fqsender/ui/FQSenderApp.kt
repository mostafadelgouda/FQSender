package com.example.fqsender.ui

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

enum class FQSenderScreen(val title: String) {
    MainScreen(title = "Main Screen"),
    LogInScreen(title = "Log In"),
    //HistoryScreen(title = "History Screen"),

}

/**
 * Composable that displays the topBar and displays back button if back navigation is possible.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductCalculatorAppBar(
    currentScreenTitle: String,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    TopAppBar(
        //colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer ),
        title = {

            Text(
                text = if (currentScreenTitle == "Main Screen") "Product Calculator" else currentScreenTitle,
                modifier = Modifier.fillMaxWidth()
            )

        },
        modifier = modifier,

        actions = {


        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun FQSenderApp() {
    //Create NavController
    val navController = rememberNavController()
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = FQSenderScreen.valueOf(
        backStackEntry?.destination?.route ?: FQSenderScreen.MainScreen.name
    )
    // Create ViewModel
    //val viewModel: FQSenderViewModel = viewModel(factory = ProductCalculatorViewModel.factory)
/*
    Scaffold(
        topBar = {
            ProductCalculatorAppBar(
                currentScreenTitle = currentScreen.title,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() },
                navController = navController
            )
        },
    ) { innerPadding ->
        //val uiState by viewModel._state.collectAsState()
        NavHost(navController = navController, startDestination = FQSenderScreen.LogInScreen.name) {
            composable(FQSenderScreen.MainScreen.name) {
                val viewModel = viewModel<FQSenderViewModel>()
                val state by viewModel.state.value


                SignInScreen(
                    state = state,
                    onSignInClick = {
                        lifecycleScope.launch {
                            val signInIntentSender = googleAuthUiClient.signIn()
                            launcher.launch(
                                IntentSenderRequest.Builder(
                                    signInIntentSender ?: return@launch
                                ).build()
                            )
                        }
                    }
                )
            }
            composable("profile") {
                ProfileScreen(
                    userData = googleAuthUiClient.getSignedInUser(),
                    onSignOut = {
                        lifecycleScope.launch {
                            googleAuthUiClient.signOut()
                            Toast.makeText(
                                applicationContext,
                                "Signed out",
                                Toast.LENGTH_LONG
                            ).show()

                            navController.popBackStack()
                        }
                    }
                )
            }
        }
    }

    */
}