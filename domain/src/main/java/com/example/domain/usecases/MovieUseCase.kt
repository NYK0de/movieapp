package com.example.domain.usecases

import com.example.domain.common.MovieResult
import com.example.domain.models.MovieResponseUI
import kotlinx.coroutines.flow.Flow

interface MovieUseCase {
    fun getMovies() : Flow<MovieResult<MovieResponseUI>>
}