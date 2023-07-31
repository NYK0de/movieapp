package com.example.domain.common

import com.example.domain.models.AppError

sealed class MovieResult <out  T>{
    data class Success<out T>(val data: T): MovieResult<T>()
    data class Error<T>(val error: AppError): MovieResult<T>()
    data class Loading<T>(val data: T? = null): MovieResult<T>()
}