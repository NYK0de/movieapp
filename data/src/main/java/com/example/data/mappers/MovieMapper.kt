package com.example.data.mappers

import com.example.data.dtos.DatesResponseDTO
import com.example.data.dtos.MovieDTO
import com.example.data.dtos.MovieResponseDTO
import com.example.domain.models.MovieResponseUI
import com.example.domain.models.MovieUI
import com.example.domain.models.ResponseDateUI

fun MovieResponseDTO.toUI() : MovieResponseUI {
    return MovieResponseUI(
        page = this.page,
        dates = this.dates?.toUI(),
        movies = this.movies.map { it.toUI() },
        totalPages = this.totalPages,
        totalResults = this.totalResults
    )
}

fun DatesResponseDTO.toUI() : ResponseDateUI {
    return ResponseDateUI(
        minimum = this.minimum,
        maximum = this.maximum
    )
}

fun MovieDTO.toUI() : MovieUI {
    return MovieUI(
        id = this.id,
        adult = this.adult,
        backDropPath = this.backdropPath,
        genreIds = this.genreIds,
        originalTitle = this.originalTitle,
        originalLanguage = this.originalLanguage,
        overview = this.overview,
        posterPath = this.posterPath,
        releaseDate = this.releaseDate,
        voteCount = this.voteCount ?: 0
    )
}