package com.it.shka.feature_auth.data.repository

import com.it.shka.core.database.data.AppDatabase
import com.it.shka.core.database.data.entity.UserIdEntity
import com.it.shka.feature_auth.data.api.ApiAuthUsers
import com.it.shka.feature_auth.data.model.User
import com.it.shka.feature_auth.data.toDataEntity
import com.it.shka.feature_auth.domain.AuthUserRepository
import com.it.shka.feature_auth.domain.Result
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthUserRepositoryImp @Inject constructor(private val apiAuthUsers: ApiAuthUsers, private val db: AppDatabase) :
    AuthUserRepository{
        private var stateValidEmail: Boolean = false


    override suspend fun getEmailServer() : List<User>{
        return apiAuthUsers.checkEmail()
    }

    override suspend fun setServerUser(user: User): Result {
        apiAuthUsers.registerUser(user)
        delay(2000)
        return Result(success = true)
    }

    override suspend fun setDatabaseUserId(user: UserIdEntity): Result {
        db.userIdDao().setUserId(user)
        delay(2000)
        return Result(success = true)
    }

    override fun registerUser(user: User): Flow<Pair<Result, Result>> {
       return insertUserServer(user = user).combine(insertUserRoom(user = user.toDataEntity())) {resultServer, resultRoom->
           resultServer to resultRoom
       }
    }

    override fun insertUserRoom(user: UserIdEntity)=flow {
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