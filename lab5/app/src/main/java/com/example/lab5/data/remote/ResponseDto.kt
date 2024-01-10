package com.example.lab5.data.remote

import com.google.gson.annotations.SerializedName

data class ResponseDto(
    val page: Int,
    @SerializedName("results")
    val movies: List<MovieDto>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)
