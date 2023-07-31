package com.example.data.di

import com.example.data.dtos.MovieResponseDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiMethods {

    @GET("now_playing")
    suspend fun getNowPlayingMovies(@Query("api_key") apiKey: String): Response<MovieResponseDTO>
}