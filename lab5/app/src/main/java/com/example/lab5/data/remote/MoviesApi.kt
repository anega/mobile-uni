package com.example.lab5.data.remote

import com.example.lab5.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {
    @GET("movie/popular?api_key=${BuildConfig.TMDB_APIKEY}&language=en-US")
    suspend fun getMovies(
        @Query("page") page: Int
    ): ResponseDto

    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"
    }
}