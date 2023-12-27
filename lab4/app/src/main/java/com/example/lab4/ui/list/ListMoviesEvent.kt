package com.example.lab4.ui.list

import com.example.lab4.data.models.Movie

sealed class ListMoviesEvent {
    data class OnDeleteMovie(val movie: Movie) : ListMoviesEvent()
}