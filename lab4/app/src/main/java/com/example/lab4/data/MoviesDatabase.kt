package com.example.lab4.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lab4.data.models.Movie

@Database(
    entities = [Movie::class],
    version = 1
)
abstract class MoviesDatabase : RoomDatabase() {
    abstract val dao: MovieDao
}