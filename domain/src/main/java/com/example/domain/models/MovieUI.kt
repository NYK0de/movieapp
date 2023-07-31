package com.example.domain.models

data class MovieResponseUI(
   val dates : ResponseDateUI?,
   val page : Int?,
   val movies : List<MovieUI>,
   val totalPages : Int?,
   val totalResults: Int?
)

data class ResponseDateUI(
    val minimum : String?,
    val maximum : String?
)

data class MovieUI(
    val id: Int?,
    val adult: Boolean?,
    val backDropPath: String?,
    val genreIds: List<Int>?,
    val originalTitle: String?,
    val originalLanguage: String?,
    val overview: String?,
    val posterPath: String?,
    val releaseDate: String?,
    val voteCount: Int
)