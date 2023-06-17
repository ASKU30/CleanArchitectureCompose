package com.example.data.repository.dataSource

import com.example.domain.model.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getPopularMovies(): Response<MovieList>
}