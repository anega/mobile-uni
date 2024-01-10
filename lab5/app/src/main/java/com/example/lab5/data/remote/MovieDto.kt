package com.example.lab5.data.remote

import com.example.lab5.data.local.MovieEntity
import com.example.lab5.data.local.MovieRemoteKeyEntity
import com.google.gson.annotations.SerializedName

data class MovieDto(
    val id: Int,
    val title: String,
    @SerializedName("poster_path")
    val posterPath: String,
    val overview: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("vote_average")
    val voteAverage: Double
) {
    fun toMovieRemoteKeyEntity(prevKey: Int?, currentPage: Int, nextKey: Int?): MovieRemoteKeyEntity {
        return MovieRemoteKeyEntity(
            movieId = id,
            prevKey = prevKey,
            currentPage = currentPage,
            nextKey = nextKey
        )
    }

    fun toMovieEntity(page: Int): MovieEntity {
        return MovieEntity(
            id = id,
            title = title,
            posterPath = posterPath,
            overview = overview,
            releaseDate = releaseDate,
            voteAverage = voteAverage,
            page = page
        )
    }
}
