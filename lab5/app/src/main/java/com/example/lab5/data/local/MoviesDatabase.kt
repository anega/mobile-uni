package com.example.lab5.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [MovieEntity::class],
    version = 1
)
abstract class MoviesDatabase: RoomDatabase() {
    abstract val moviesDao: MoviesDao
}