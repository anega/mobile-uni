package com.example.lab4.ui.list

import androidx.lifecycle.ViewModel
import com.example.lab4.data.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val repository: MoviesRepository
): ViewModel() {
    val movies = repository.getAllMovies()
}