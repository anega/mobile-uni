package com.example.lab4.data

import androidx.room.Dao
import androidx.room.Query
import com.example.lab4.data.models.Movie
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Query("SELECT * FROM movies")
    fun getAllMovies(): Flow<List<Movie>>
}