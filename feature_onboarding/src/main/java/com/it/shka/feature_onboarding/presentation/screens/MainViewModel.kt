package com.it.shka.feature_onboarding.presentation.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.it.shka.feature_onboarding.data.repository.DataRepositoryImp
import com.it.shka.feature_onboarding.presentation.model.UserIdUi
import com.it.shka.feature_onboarding.presentation.mapper.toDomainUserId
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val repositoryImp: DataRepositoryImp) : ViewModel(){
   private val _userIdState = MutableStateFlow(UserIdUi(null))
    val userIdState: StateFlow<UserIdUi> = _userIdState
    init {
        viewModelScope.launch {
            try {
                val userId = repositoryImp.getUserId()?.toDomainUserId()
                _userIdState.update { it.copy(authId = userId.toString()) }
            }catch (e: Exception){
                println(e.message)
                _userIdState.update { it.copy(authId = null) }
            }
        }
    }

}