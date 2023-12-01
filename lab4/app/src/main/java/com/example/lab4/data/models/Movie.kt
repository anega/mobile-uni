package com.example.lab4.data.models

data class Movie(
    val id: Int,
    val posterPath: String,
    val title: String,
    val overview: String,
//    val mediaType: String,
    val releaseDate: String,
    val voteAverage: Double,
//    val voteCount: Int
)