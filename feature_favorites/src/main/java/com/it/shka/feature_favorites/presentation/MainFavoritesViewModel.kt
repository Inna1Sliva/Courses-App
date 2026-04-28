package com.it.shka.feature_favorites.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.it.shka.feature_favorites.domain.model.Courses
import com.it.shka.feature_favorites.domain.repository.DataFavoritesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.onFailure

@HiltViewModel
class MainFavoritesViewModel @Inject constructor(private val repository: DataFavoritesRepository) :
    ViewModel() {
    private val _coursesFavorites = MutableStateFlow<FavoritesUiState>(FavoritesUiState.Empty)
    val coursesFavorites: StateFlow<FavoritesUiState> = _coursesFavorites

    init {
        viewModelScope.launch {
            _coursesFavorites.value = FavoritesUiState.Loading
            repository.getFavoritesCourses()
                .onSuccess {
                    when {
                        it.isNotEmpty() -> {
                            _coursesFavorites.value = FavoritesUiState.Success(it)
                        }

                        else -> {
                            _coursesFavorites.value = FavoritesUiState.Empty
                        }
                    }
                }
                .onFailure { _coursesFavorites.value = FavoritesUiState.Error }
        }
    }

    fun deleteCoursesId(id: Int) {
        viewModelScope.launch {
            val currentState = _coursesFavorites.value
            repository.deleteCoursesId(id = id)
                .onSuccess {
                    when {
                        currentState is FavoritesUiState.Success -> {
                            val updated = currentState.courses.filter { it.id != id }
                            if (updated.isEmpty()){_coursesFavorites.value = FavoritesUiState.Empty
                            }else{_coursesFavorites.value = FavoritesUiState.Success(updated)
                            }
                        }
                    }
                }
                .onFailure {
                    Log.e("MainFavoritesViewModel", "delete failed", it)
                }
        }
    }


}