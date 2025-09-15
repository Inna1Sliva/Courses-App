package com.it.shka.feature_auth.presentation.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.it.shka.feature_auth.data.repository.AuthUserRepositoryImp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthUserViewModel @Inject constructor (private val repository: AuthUserRepositoryImp) : ViewModel(){
    private val _authMessage = MutableStateFlow<String>("")
    val authMessage: StateFlow<String> get() = _authMessage

    init {
        viewModelScope.launch {
         // repository.e
        }

    }
    fun registerUser(email: String, password: String, repeatPassword: String){
        when{
            email.isEmpty() || password.isEmpty() || repeatPassword.isEmpty() ->{
                _authMessage.value = "Пожалуйста, заполните все поля"

                return
            }
                repository.validateEmail(email)->{
                    _authMessage.value =  "Некорректный формат почты"
                    //return
            }
            repository.validatePassword(password,repeatPassword)->{
                _authMessage.value = "Пароли не совпадают"
                return
            }
            isEmailExists(email,password)->{
                return
            }

        }
    }
  private  fun isEmailExists(email: String, password: String): Boolean{
        var state: Boolean = true
       repository.isEmailExists(email) { exists->
         when(exists){
             true->{
                 _authMessage.value = "Пользователь с такой почтой уже существует"
                 Log.d("Regist", "Пользователь с такой почтой уже существует")
                 state
             }
             false ->{
                 repository.registerUser(email, password)
                 state = false
                 Log.d("Regist", "Пользователь успешно зарегистрирован")
             }
         }
        }
        return state
    }
}