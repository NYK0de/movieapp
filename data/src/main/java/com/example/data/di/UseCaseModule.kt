package com.example.data.di

import com.example.data.repositories.MovieRepository
import com.example.domain.repositories.MovieDatasource
import com.example.domain.usecases.MovieInteractor
import com.example.domain.usecases.MovieUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    @ViewModelScoped
    fun provideOurUseCase(
        repository: MovieRepository
    ) : MovieUseCase = MovieInteractor(repository)

}