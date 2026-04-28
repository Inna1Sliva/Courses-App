package com.it.shka.feature_bottom_nav.presentation.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.it.shka.feature_bottom_nav.domain.repository.DataBottomNavRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class BottomNavViewModel @Inject constructor(private val repository: DataBottomNavRepository): ViewModel() {
    val badgeFavorites : StateFlow<Int> =repository.getCountFavorites().stateIn(
        scope = viewModelScope,
        started = SharingStarted.Companion.Lazily,
        initialValue = 0
    )
}