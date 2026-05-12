package com.it.shka.feature_auth.data.repository

import com.it.shka.core.data.AppDatabase
import com.it.shka.core.data.entity.UserTokenEntity
import com.it.shka.feature_auth.data.api.ApiAuthUsers
import com.it.shka.feature_auth.data.model.User
import com.it.shka.feature_auth.domain.AuthUserRepository
import com.it.shka.feature_auth.domain.UserToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthUserRepositoryImp @Inject constructor(private val api: ApiAuthUsers, private val db: AppDatabase) :
    AuthUserRepository{
        private var stateValidEmail: Boolean = false


    override suspend fun getEmailServer() : List<User>{
        return api.checkEmail()
    }

    override suspend fun setServerUser(user: User): Result {
        api.registerUser(user)
        delay(2000)
        return Result(success = true)
    }

    override suspend fun setDatabaseUserId(user: UserTokenEntity): Result {
        db.userIdDao().setUserId(user)
        delay(2000)
        return Result(success = true)
    }

    override suspend fun registerUser(user: User): Result<UserToken> {
       return withContext(Dispatchers.IO){
           runCatching {
               api.registerUser(user)
           }
       }
    }

    override fun insertUserRoom(user: UserTokenEntity)=flow {
       val result = setDatabaseUserId(user)
        emit(result)
    }

    override fun insertUserServer(user: User) =flow {
      val result= setServerUser(user = user)
        emit(result)
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
        repeatPassword: String
    ): Boolean {
        return password != repeatPassword
    }

}