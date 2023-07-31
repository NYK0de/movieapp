package com.example.data.repositories

import com.example.data.BuildConfig
import com.example.data.di.ApiMethods
import com.example.data.dtos.MovieResponseDTO
import com.example.data.mappers.toUI
import com.example.domain.common.MovieResult
import com.example.domain.models.AppError
import com.example.domain.models.MovieResponseUI
import com.example.domain.repositories.MovieDatasource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.*
import javax.inject.Inject


class MovieRepository @Inject constructor(
    private val apiMethods: ApiMethods
) : MovieDatasource{

    override fun getMovies(): Flow<MovieResult<MovieResponseUI>> {
        return flow<MovieResult<MovieResponseUI>>{
            emit(MovieResult.Loading(null))
            val response = apiMethods.getNowPlayingMovies(BuildConfig.API_KEY)

            if (response.body() != null){
                if (response.isSuccessful){
                    val movieResponse = response.body() as MovieResponseDTO
                    val responseUI = movieResponse.toUI()
                    emit(
                        MovieResult.Success(
                            data = responseUI
                        )
                    )
                }
                else{
                    emit(MovieResult.Error(
                        AppError(
                            code = 500,
                            message = response.message()
                        )
                    ))
                }
            }
            else {
                emit(MovieResult.Error(
                    AppError(
                        code = 500,
                        message = response.message()
                    )
                ))
            }

        }.onStart {
            emit(MovieResult.Loading(null))
        }.catch {
            emit(MovieResult.Error(
                AppError(
                    code = 500,
                    message = it.message.toString()
                )
            ))
        }.flowOn(Dispatchers.IO)
    }


}