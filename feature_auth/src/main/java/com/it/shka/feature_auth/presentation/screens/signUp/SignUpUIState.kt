package com.it.shka.feature_auth.presentation.screens.signUp

sealed class SignUpUIState {
    object Loading: SignUpUIState()
    object Empty: SignUpUIState()
    object Success: SignUpUIState()
    object Error: SignUpUIState()
}