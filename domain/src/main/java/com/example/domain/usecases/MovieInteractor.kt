package com.example.domain.usecases

import com.example.domain.common.MovieResult
import com.example.domain.models.MovieResponseUI
import com.example.domain.repositories.MovieDatasource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieInteractor @Inject constructor(
    private val movieDatasource: MovieDatasource
) : MovieUseCase {
    override fun getMovies(): Flow<MovieResult<MovieResponseUI>> {
        return movieDatasource.getMovies()
    }
}