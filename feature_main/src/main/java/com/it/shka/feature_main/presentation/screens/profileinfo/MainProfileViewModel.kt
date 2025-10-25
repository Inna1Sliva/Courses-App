package com.it.shka.feature_main.presentation.screens.profileinfo

import androidx.lifecycle.ViewModel
import com.it.shka.feature_main.data.repository.ProfileUserRepositoryImp
import com.it.shka.feature_main.presentation.model.CoursesProfileUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class MainProfileViewModel(private val repository: ProfileUserRepositoryImp): ViewModel() {

}