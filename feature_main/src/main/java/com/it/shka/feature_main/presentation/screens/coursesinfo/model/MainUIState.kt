package com.it.shka.feature_main.presentation.screens.coursesinfo.model




sealed class MainUIState(){
    object Loading : MainUIState()
    object Success:MainUIState()
    object Error : MainUIState()
}