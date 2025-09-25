package com.it.shka.feature_auth.presentation.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.it.shka.feature_auth.data.model.User
import com.it.shka.feature_auth.data.repository.AuthUserRepositoryImp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class AuthUserViewModel @Inject constructor (private val repository: AuthUserRepositoryImp) : ViewModel(){
    private val _authMessage = MutableStateFlow<String>("")
    val authMessage: StateFlow<String> get() = _authMessage

    init {
        viewModelScope.launch {

        }


    }
    fun registerUser(email: String, password: String, repeatPassword: String){
      viewModelScope.launch {
        when{
            email.isEmpty() || password.isEmpty() || repeatPassword.isEmpty() ->{
                _authMessage.value = "Пожалуйста, заполните все поля"

               // return
            }
                repository.validateEmail(email)->{
                    _authMessage.value =  "Некорректный формат почты"
                    //return
            }
            repository.validatePassword(password,repeatPassword)->{
                _authMessage.value = "Пароли не совпадают"
              //  return
            }
         repository.isEmailExists(email)->{
               _authMessage.value = "Пользователь с такой почтой уже существует"
              // return
            }

            false->{
                seveNewUser(email,password)
            }


        }
      }
    }



    private  fun seveNewUser(email: String, password: String){
        var state: Boolean = true
        val userId = UUID.randomUUID().toString()

                 viewModelScope.launch {
                     val user = User(id = userId, email = email, password = password)
                     repository.registerUser(user)
                         .collect { (resultServer, resultRoom) ->
                             resultServer to resultRoom
                         }
                 }


                 Log.d("Regist", "Пользователь успешно зарегистрирован")




    }
}