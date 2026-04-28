package com.it.shka.feature_favorites.presentation

import com.it.shka.feature_favorites.domain.model.Courses

sealed class FavoritesUiState {
    object Loading: FavoritesUiState()
    data class Success(val courses: List<Courses>): FavoritesUiState()
    object Error: FavoritesUiState()
    object Empty: FavoritesUiState()

}