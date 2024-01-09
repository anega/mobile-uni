package com.example.lab5.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    @ColumnInfo("poster_path")
    val posterPath: String,
    val overview: String,
    @ColumnInfo("release_date")
    val releaseDate: String,
    @ColumnInfo("vote_average")
    val voteAverage: String,
    val page: Int
)
