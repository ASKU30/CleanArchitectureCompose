package com.example.data.repository.dataSourceImpl

import com.example.data.BuildConfig
import com.example.data.api.MovieApi
import com.example.data.repository.dataSource.MovieRemoteDataSource

class MovieRemoteDataSourceImpl(private val movieApi: MovieApi): MovieRemoteDataSource {
    override suspend fun getPopularMovies()= movieApi.getPopularMovies(BuildConfig.API_KEY)
}