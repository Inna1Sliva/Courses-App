package com.it.shka.feature_auth.presentation.screens

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.it.shka.feature_auth.R
import com.it.shka.feature_auth.data.model.User
import com.it.shka.feature_auth.data.repository.AuthUserRepositoryImp
import com.it.shka.feature_auth.presentation.model.AuthStateResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class AuthUserViewModel @Inject constructor (private val repository: AuthUserRepositoryImp) : ViewModel(){
    val _authMessage = MutableStateFlow(AuthStateResult())
    val authMessage: StateFlow<AuthStateResult> get() = _authMessage
    private val _userAll = mutableListOf<User>()
    val userAll: List<User> get() = _userAll
    private var state: Boolean = false
    private val userId = UUID.randomUUID().toString()

    init {
     getAllUser()
    }

    fun registerUser(email: String, password: String, repeatPassword: String, context: Context){
       //_authMessage.update { it.copy(loading = true, message = "") }
        viewModelScope.launch {
        when{
            email.isEmpty() || password.isEmpty() || repeatPassword.isEmpty() ->{
                _authMessage.update { it.copy(loading = false, message = context.getString( R.string.errorMessageEmpty)) }
            }
            repository.validateEmail(email = email)->{
                _authMessage.update { it.copy(loading = false, message = context.getString(R.string.errorMessageValidateEmail)) }
            }
            repository.validatePassword(password = password, repeatPassword = repeatPassword)->{
                _authMessage.update {it.copy(loading = false, message = context.getString(R.string.errorMessageValidatePassword))}
            }
            isEmailExist(email = email)->{
               _authMessage.update {it.copy(loading = false, message = context.getString(R.string.errorMessageEmailExist))}
            }
            setNewUser(email=email,password=password)->{
                _authMessage.update {it.copy(loading = false, message = context.getString(R.string.errorMessageAuth)) }
            }
        }
       delay(5000)
      }
    }
    private fun isEmailExist(email: String): Boolean{
        return userAll.any { it.email.equals(email,ignoreCase = true) }
    }

    private  fun setNewUser(email: String, password: String): Boolean{
        try {
            viewModelScope.launch {
                val user = User(id = userId, email = email, password = password)
                repository.registerUser(user)
                    .collect { (resultServer, resultRoom) ->
                      resultServer.success to resultRoom.success
                        state = resultServer.success
                    }
            }

        }catch (e: Exception){
            e.printStackTrace()
            state= false
        }
        return state

    }
    private fun getAllUser(){
        viewModelScope.launch {
            try {
                val emailServer = repository.getEmailServer()
             _userAll.addAll(emailServer)
            }catch (e: Exception){
                e.printStackTrace()

            }
        }
    }
}