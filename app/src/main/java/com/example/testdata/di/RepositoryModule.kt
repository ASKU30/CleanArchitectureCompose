package com.farhan.tanvir.androidcleanarchitecture.di

import com.example.data.repository.MovieRepositoryImpl
import com.example.data.repository.dataSource.MovieRemoteDataSource
import com.example.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideMoviesRepository(movieRemoteDataSource: MovieRemoteDataSource) : MovieRepository=
        MovieRepositoryImpl(movieRemoteDataSource)
}