package com.example.lab4.ui.movie

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab4.data.MoviesRepository
import com.example.lab4.data.models.Movie
import com.example.lab4.ui.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val repository: MoviesRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    var id by mutableIntStateOf(-1)
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

    private val _uiEvent = MutableSharedFlow<UiEvent>()
    val uiEvent = _uiEvent.asSharedFlow()

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
            is AddEditMovieEvent.OnIdChange -> id = event.id
            is AddEditMovieEvent.OnTitleChange -> title = event.title
            is AddEditMovieEvent.OnPosterPathChange -> posterPath = event.posterPath
            is AddEditMovieEvent.OnOverviewChange -> overview = event.overview
            is AddEditMovieEvent.OnReleaseDateChange -> {
                val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                val calendar = Calendar.getInstance()
                calendar.timeInMillis = event.releaseDate
                releaseDate = formatter.format(calendar.time).toString()
            }
            is AddEditMovieEvent.OnVoteAverageChange -> voteAverage = event.voteAverage
            is AddEditMovieEvent.OnSaveMovie -> {
                viewModelScope.launch {
                    val currentMovie: Movie
                    if (id == -1) {
                        currentMovie = Movie(
                            title = title,
                            posterPath = posterPath,
                            overview = overview,
                            releaseDate = releaseDate,
                            voteAverage = voteAverage.toDouble()
                        )
                    } else {
                        currentMovie = Movie(
                            id = id,
                            title = title,
                            posterPath = posterPath,
                            overview = overview,
                            releaseDate = releaseDate,
                            voteAverage = voteAverage.toDouble()
                        )
                    }
                    repository.addMovie(currentMovie)
                    onUiEvent(UiEvent.PopBackStack)
                }
            }
        }
    }

    private fun onUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.emit(event)
        }
    }
}