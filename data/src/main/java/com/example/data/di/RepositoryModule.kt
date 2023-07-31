package com.example.data.di

import com.example.data.repositories.MovieRepository
import com.example.domain.repositories.MovieDatasource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideRepository(
        apiMethods: ApiMethods
    ) : MovieDatasource = MovieRepository(apiMethods)

}