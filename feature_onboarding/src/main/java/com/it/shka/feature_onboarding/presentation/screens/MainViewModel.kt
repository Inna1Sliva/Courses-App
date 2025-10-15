package com.it.shka.feature_onboarding.presentation.screens

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.it.shka.feature_onboarding.data.repository.DataRepositoryImp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val repositoryImp: DataRepositoryImp) : ViewModel(){
   private val _startScreen = mutableStateOf<StartScreen?>(null)
    val startScreen: State<StartScreen?> = _startScreen
    init {
        viewModelScope.launch {
            try {
                val data = repositoryImp.getUserId()
               _startScreen.value = if (data == 0){
                   StartScreen.Registration
               }else{
                   StartScreen.Main
               }
            }catch (e: Exception){
                println(e.message)

            }
        }
    }

}