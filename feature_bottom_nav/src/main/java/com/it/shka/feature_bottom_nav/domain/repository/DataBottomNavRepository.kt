package com.it.shka.feature_bottom_nav.domain.repository

import kotlinx.coroutines.flow.Flow

interface DataBottomNavRepository {
     fun getCountFavorites(): Flow<Int>
}