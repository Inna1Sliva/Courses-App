package com.it.shka.feature_main.presentation.screens.favoritesinfo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.it.shka.feature_main.data.repository.MainCoursesRepositoryImp
import com.it.shka.feature_main.presentation.mapper.toCourses
import com.it.shka.feature_main.presentation.model.CoursesModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainFavoritesViewModel @Inject constructor(private val repository: MainCoursesRepositoryImp): ViewModel() {
    private val _coursesFavorites = MutableStateFlow<List<CoursesModel>>(emptyList())
    val coursesFavorites: StateFlow<List<CoursesModel>> = _coursesFavorites
    init {
        viewModelScope.launch {
            _coursesFavorites.value = repository.getFavoritesCourses().toCourses()
        }
    }


}