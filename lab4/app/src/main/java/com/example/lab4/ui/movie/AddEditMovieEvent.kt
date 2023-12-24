package com.example.lab4.ui.movie

sealed class AddEditMovieEvent {
    data class OnTitleChange(val title: String) : AddEditMovieEvent()
    data class OnPosterPathChange(val posterPath: String) : AddEditMovieEvent()
    data class OnOverviewChange(val overview: String) : AddEditMovieEvent()
    data class OnReleaseDateChange(val releaseDate: String) : AddEditMovieEvent()
    data class OnVoteAverageChange(val voteAverage: String) : AddEditMovieEvent()
}