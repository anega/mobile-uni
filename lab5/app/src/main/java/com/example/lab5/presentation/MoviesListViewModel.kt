package com.example.lab5.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.lab5.data.local.MovieEntity
import com.example.lab5.data.local.MoviesDatabase
import com.example.lab5.data.paging.MoviesRemoteMediator
import com.example.lab5.data.remote.MoviesApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
@HiltViewModel
class MoviesListViewModel @Inject constructor(
    moviesApi: MoviesApi,
    private val moviesDb: MoviesDatabase
) : ViewModel() {
    val movies = Pager(
        config = PagingConfig(
            pageSize = 20,
            prefetchDistance = 2,
            initialLoadSize = 20
        ),
        pagingSourceFactory = {
            moviesDb.moviesDao.pagingSource()
        },
        remoteMediator = MoviesRemoteMediator(
            moviesApi = moviesApi,
            moviesDb = moviesDb
        )
    )
        .flow
        .map { pagingData: PagingData<MovieEntity> ->
            pagingData.map { it.toMovie() }
        }
        .cachedIn(viewModelScope)
}