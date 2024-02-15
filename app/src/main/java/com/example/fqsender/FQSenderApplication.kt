package com.example.fqsender

import android.app.Application
import androidx.compose.ui.text.input.OffsetMapping.Companion.Identity
import com.example.fqsender.presentation.sign_in.GoogleAuthUiClient
import kotlin.math.sign
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import kotlin.math.sign

class FQSenderApplication : Application() {

    val googleAuthUiClient by lazy {
        GoogleAuthUiClient(
            context = applicationContext,
            oneTapClient = Identity.getSignInClient(applicationContext)
        )
    }
}