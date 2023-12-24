package com.example.lab4.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab4.data.MoviesRepository
import com.example.lab4.data.models.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val repository: MoviesRepository
): ViewModel() {
    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies = _movies.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getAllMovies().collect {
                _movies.value = it
            }
        }
    }

}