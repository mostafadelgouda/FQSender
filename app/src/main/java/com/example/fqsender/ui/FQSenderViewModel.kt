package com.example.fqsender.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.fqsender.FQSenderApplication
import com.example.fqsender.presentation.sign_in.GoogleAuthUiClient
import com.example.fqsender.presentation.sign_in.SignInResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class SignInState(
    val isSignInSuccessful: Boolean = false,
    val signInError: String? = null
)

class FQSenderViewModel(googleAuthUiClient: GoogleAuthUiClient) : ViewModel(

) {

    private val _state = MutableStateFlow(SignInState())
    val state = _state.asStateFlow()

    fun onSignInResult(result: SignInResult) {
        _state.update { it.copy(
            isSignInSuccessful = result.data != null,
            signInError = result.errorMessage
        ) }
    }

    fun resetState() {
        _state.update { SignInState() }
    }
    companion object {
        val factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as FQSenderApplication)
                FQSenderViewModel(application.googleAuthUiClient)
            }
        }
    }
}