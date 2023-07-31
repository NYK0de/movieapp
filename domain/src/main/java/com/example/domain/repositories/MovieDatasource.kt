package com.example.domain.repositories

import com.example.domain.common.MovieResult
import com.example.domain.models.MovieResponseUI
import kotlinx.coroutines.flow.Flow

interface MovieDatasource {
    fun getMovies(): Flow<MovieResult<MovieResponseUI>>
}