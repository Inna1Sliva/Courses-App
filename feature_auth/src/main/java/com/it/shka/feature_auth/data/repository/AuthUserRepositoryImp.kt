package com.it.shka.feature_auth.data.repository

import android.util.Log
import com.it.shka.feature_auth.data.api.ApiAuthUsers
import com.it.shka.feature_auth.data.database.AppUserIdDatabase
import com.it.shka.feature_auth.data.model.AuthStateResult
import com.it.shka.feature_auth.data.model.User
import com.it.shka.feature_auth.domain.AuthUserRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class AuthUserRepositoryImp @Inject constructor(private val apiAuthUsers: ApiAuthUsers, private val db: AppUserIdDatabase) :
    AuthUserRepository{
        private var stateValidEmail: Boolean = false


    override fun isEmailExists(email: String, callback:(Boolean)->Unit) {
       apiAuthUsers.checkEmail().enqueue(object : Callback<List<User>>{
           override fun onResponse(
               call: Call<List<User>>,
               response: Response<List<User>>
           ) {
               if (response.isSuccessful){
                val existingUser = response.body()?.find {
                       it.email.equals(email, ignoreCase = true)
                   }
                  if (existingUser !=null){
                      callback(true)
                  }else{
                      callback(false)
                  }

               }else{
                   Log.d("Retrofit", "${response.code()}")
               }
           }

           override fun onFailure(call: Call<List<User>>, t: Throwable) {
              //callback(false)
               Log.d("Retrofit", "${t.message}")
           }

       })
    }


    override fun registerUser(email: String, password: String){
           val user = User(email, email, password)

           apiAuthUsers.registerUser(user).enqueue(object : Callback<AuthStateResult> {
               override fun onResponse(
                   call: Call<AuthStateResult?>,
                   response: Response<AuthStateResult?>
               ) {
                 if (response.isSuccessful){
                     val apiResponse = response.body()
                     if (apiResponse!= null && apiResponse.success){
                         Log.d("POST", " Пользователь успешно зарегистрирован")
                     }else{
                         Log.d("POST", "Ошибка регистрации: ${apiResponse?.message}")

                     }

                 }else{
                     Log.d("POST", "Ошибка сервера")
                 }
               }

               override fun onFailure(
                   call: Call<AuthStateResult?>,
                   t: Throwable
               ) {
                   Log.d("POST", "Ошибка сети")
               }

           })
       }

    override fun validateEmail(email: String): Boolean {
        val emailRegex = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        when(email.matches(emailRegex.toRegex())){
            true->{
                stateValidEmail=false
            }
            false->{
                stateValidEmail= true
            }
        }
        return stateValidEmail
    }

    override fun validatePassword(
        password: String,
        repidPassword: String
    ): Boolean {
        return password != repidPassword
    }

}