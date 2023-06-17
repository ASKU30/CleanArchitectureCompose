package com.example.testdata.di

import com.example.domain.repository.MovieRepository
import com.example.domain.useCase.GetPopularMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideGetPopularMoviesUseCase(movieRepository: MovieRepository) =
       GetPopularMoviesUseCase(movieRepository)
}