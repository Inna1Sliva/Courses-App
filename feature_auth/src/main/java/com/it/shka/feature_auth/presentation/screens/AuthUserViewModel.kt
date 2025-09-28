package com.it.shka.feature_auth.presentation.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.it.shka.feature_auth.data.model.User
import com.it.shka.feature_auth.data.repository.AuthUserRepositoryImp
import com.it.shka.feature_auth.domain.Result
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
    private var state: Boolean = false
    private val userId = UUID.randomUUID().toString()


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

            seveNewUser(email,password)->{
                _authMessage.value = "Ошибка регистрации"

            }


        }
      }
    }



    private  fun seveNewUser(email: String, password: String): Boolean{

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





                // Log.d("Regist", "Пользователь успешно зарегистрирован")




    }
}