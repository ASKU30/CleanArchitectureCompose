package com.example.testdata.di

import com.example.data.api.MovieApi
import com.example.data.repository.dataSource.MovieRemoteDataSource
import com.example.data.repository.dataSourceImpl.MovieRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {
    @Provides
    fun provideMoviesRemoteDataSource(movieApi: MovieApi) : MovieRemoteDataSource =
        MovieRemoteDataSourceImpl(movieApi)
}