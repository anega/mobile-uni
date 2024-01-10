package com.example.lab5.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface MoviesDao {
    @Upsert
    suspend fun upsertAllMovies(movies: List<MovieEntity>)

    @Query("SELECT * FROM movies ORDER BY page")
    fun pagingSource(): PagingSource<Int, MovieEntity>

    @Query("DELETE FROM movies")
    suspend fun deleteAllMovies()
}