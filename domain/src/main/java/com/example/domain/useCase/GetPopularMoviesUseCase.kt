package com.example.domain.useCase

import com.example.domain.repository.MovieRepository

class GetPopularMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend operator fun invoke() = movieRepository.getPopularMovies()
}