package com.example.lab4.data

import com.example.lab4.data.models.Movie
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    fun getAllMovies(): Flow<List<Movie>>

    suspend fun getMovieById(id: Int): Movie?

    suspend fun addMovie(movie: Movie)

    suspend fun deleteMovie(movie: Movie)
}