package com.example.lab4.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class Movie(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val posterPath: String,
    val title: String,
    val overview: String,
    val releaseDate: String,
    val voteAverage: Double
)