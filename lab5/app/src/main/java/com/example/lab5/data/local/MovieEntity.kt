package com.example.lab5.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.lab5.domain.model.Movie

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
    val voteAverage: Double,
    val page: Int
) {
    fun toMovie(): Movie {
        return Movie(
            id = id,
            title = title,
            posterPath = posterPath,
            overview = overview,
            releaseDate = releaseDate,
            voteAverage = voteAverage
        )
    }
}
