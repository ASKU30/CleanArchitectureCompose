package com.example.data.repository

import com.example.data.repository.dataSource.MovieRemoteDataSource
import com.example.domain.model.MovieList
import com.example.domain.repository.MovieRepository
import com.example.domain.util.Result
import retrofit2.Response

class MovieRepositoryImpl(private val movieRemoteDataSource: MovieRemoteDataSource) :
    MovieRepository {

    override suspend fun getPopularMovies() = responseToRequest(movieRemoteDataSource.getPopularMovies())

    private fun responseToRequest(response: Response<MovieList>): Result<MovieList> {
        if(response.isSuccessful){
            response.body()?.let {result->
                return Result.Success(result)
            }
        }
        return Result.Error(response.message())
    }
}