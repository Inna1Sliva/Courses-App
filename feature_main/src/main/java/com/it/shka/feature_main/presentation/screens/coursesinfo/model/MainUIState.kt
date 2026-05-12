package com.it.shka.feature_main.presentation.screens.coursesinfo.model

import androidx.paging.PagingData
import com.it.shka.feature_main.domain.model.Courses


sealed class MainUIState(){
    object Loading : MainUIState()
    object Success:MainUIState()
    object Error : MainUIState()
}