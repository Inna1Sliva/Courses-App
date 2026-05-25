package com.it.shka.feature_bottom_nav.presentation.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.it.shka.feature_bottom_nav.data.api.ApiServerBottomNav
import com.it.shka.feature_bottom_nav.domain.model.UserResponse
import com.it.shka.feature_bottom_nav.domain.repository.BottomNavLocalDataSourceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BottomNavViewModel @Inject constructor(
    private val local: BottomNavLocalDataSourceRepository,
    private val remote: ApiServerBottomNav
) : ViewModel() {

    private val _userResponseFlow = MutableStateFlow<UserResponse?>(null)
    val userResponseFlow: StateFlow<UserResponse?> = _userResponseFlow.asStateFlow()
    val badgeFavorites: StateFlow<Int> = local.getCountFavorites().stateIn(
        scope = viewModelScope,
        started = SharingStarted.Companion.Lazily,
        initialValue = 0
    )

    val badgeAccount: StateFlow<Int> = userResponseFlow.filter { it != null }.map { response ->
        countUnreadNotification(response!!)
    }
        .distinctUntilChanged()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = 0
        )

    init {
        getUserToken()
    }

    private fun getUserToken() {
        viewModelScope.launch {
            local.getToken().onSuccess { token ->
                _userResponseFlow.value = remote.getUser(token)
            }.onFailure {}
        }
    }

    private fun countUnreadNotification(userResponse: UserResponse): Int {
        return userResponse.notification.push.count { !it.status }
    }

}