package com.it.shka.feature_auth.presentation.screens.signUp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.it.shka.feature_auth.domain.model.RegisterRequest
import com.it.shka.feature_auth.domain.RealEmailValidationUseCase
import com.it.shka.feature_auth.domain.model.RegisterResponse
import com.it.shka.feature_auth.domain.repository.AuthLocalDataSourceRepository
import com.it.shka.feature_auth.domain.repository.AuthRemoteDataSourceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthUserViewModel @Inject constructor(
    private val remote: AuthRemoteDataSourceRepository,
    private val local: AuthLocalDataSourceRepository,
    private val useCase: RealEmailValidationUseCase
) :
    ViewModel() {
    private val _authMessage = MutableStateFlow("")
    val authMessage: StateFlow<String> get() = _authMessage
    private val _signUpUIState = MutableStateFlow<SignUpUIState>(SignUpUIState.Empty)
    val signUpUIState: StateFlow<SignUpUIState> get() = _signUpUIState


    fun register(email: String, password: String, repeatPassword: String) {
        viewModelScope.launch {
            _authMessage.value = " "
            when {
                email.isEmpty() || password.isEmpty() -> {
                    _authMessage.value = "Пожалуйста, заполните все поля"
                }

                useCase.invoke(email) -> {
                    _authMessage.value = "Некорректный формат почты"

                }

                comparePassword(password, repeatPassword) -> {
                    _authMessage.value = "Пароли не совпадают"
                }

                emailVerificationUser(email) -> {
                    _authMessage.value = "Пользователь с такой почтой уже существует"

                }

                registerUser(email, password) -> {}
            }


        }
    }

    private suspend fun registerUser(email: String, password: String): Boolean {
        _signUpUIState.value = SignUpUIState.Loading
        val user =
            RegisterRequest(email = email, password = password)
        val register = remote.registerUser(user)
            .onSuccess { success ->
                val userToken = RegisterResponse(token = success.token)
                local.insertUserRoom(userToken)
                _signUpUIState.value = SignUpUIState.Success
            }.onFailure {
                _signUpUIState.value = SignUpUIState.Error
            }
        return register.isSuccess
    }

    private suspend fun emailVerificationUser(email: String): Boolean {
        val response = remote.getUsersEmail().find { it.email == email }
        return response?.email == email

    }

    private fun comparePassword(password: String, repeatPassword: String): Boolean {
        return password != repeatPassword
    }


}