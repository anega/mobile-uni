package com.example.lab4.ui.movie

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab4.data.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val repository: MoviesRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    var id by mutableIntStateOf(0)
        private set
    var title by mutableStateOf("")
        private set
    var posterPath by mutableStateOf("")
        private set
    var overview by mutableStateOf("")
        private set
    var releaseDate by mutableStateOf("")
        private set
    var voteAverage by mutableStateOf("")
        private set
    var screenTitle by mutableStateOf("New Movie")
        private set

    init {
        viewModelScope.launch {
            val currTodoId = savedStateHandle.get<Int>("id")
            if (currTodoId != null && currTodoId != -1) {
                screenTitle = "Edit Movie"
                repository.getMovieById(currTodoId)?.let { movie ->
                    id = movie.id
                    title = movie.title
                    posterPath = movie.posterPath
                    overview = movie.overview
                    releaseDate = movie.releaseDate
                    voteAverage = movie.voteAverage.toString()
                }
            }
        }
    }

    fun onEvent(event: AddEditMovieEvent) {
        when (event) {
            is AddEditMovieEvent.OnTitleChange -> title = event.title
            is AddEditMovieEvent.OnPosterPathChange -> posterPath = event.posterPath
            is AddEditMovieEvent.OnOverviewChange -> overview = event.overview
            is AddEditMovieEvent.OnReleaseDateChange -> releaseDate = event.releaseDate
            is AddEditMovieEvent.OnVoteAverageChange -> voteAverage = event.voteAverage
        }
    }
}