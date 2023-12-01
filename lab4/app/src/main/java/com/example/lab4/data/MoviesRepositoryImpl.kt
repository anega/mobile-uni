package com.example.lab4.data

import com.example.lab4.data.models.Movie
import kotlinx.coroutines.flow.Flow

class MoviesRepositoryImpl(
    private val dao: MovieDao
) : MoviesRepository {
    override fun getAllMovies(): Flow<List<Movie>> {
        return dao.getAllMovies()
    }
}