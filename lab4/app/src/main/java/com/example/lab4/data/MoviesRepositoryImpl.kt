package com.example.lab4.data

import com.example.lab4.data.models.Movie
import kotlinx.coroutines.flow.Flow

class MoviesRepositoryImpl(
    private val dao: MovieDao
) : MoviesRepository {
    override fun getAllMovies(): Flow<List<Movie>> {
        return dao.getAllMovies()
    }

    override suspend fun getMovieById(id: Int): Movie? {
        return dao.getMovieById(id)
    }

    override suspend fun addMovie(movie: Movie) {
        dao.addMovie(movie)
    }

    override suspend fun deleteMovie(movie: Movie) {
        dao.deleteMovie(movie)
    }
}