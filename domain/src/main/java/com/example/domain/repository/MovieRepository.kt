package com.example.domain.repository

import com.example.domain.model.MovieList
import com.example.domain.util.Result

interface MovieRepository {
    suspend fun getPopularMovies():  Result<MovieList>
}