package com.example.lab5.presentation

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey

@Composable
fun ListScreen(
    viewModel: MoviesListViewModel = hiltViewModel(),
) {
    val movies = viewModel.movies.collectAsLazyPagingItems()
    val context = LocalContext.current

    LaunchedEffect(key1 = movies.loadState) {
        if (movies.loadState.refresh is LoadState.Error) {
            Toast.makeText(
                context,
                "Error: " + (movies.loadState.refresh as LoadState.Error).error.message,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        if (movies.loadState.refresh is LoadState.Loading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.padding(all = 12.dp)
            ) {
                items(
                    count = movies.itemCount,
                    key = movies.itemKey { movie -> movie.id }
                ) { index ->
                    val movie = movies[index]
                    movie?.let { MovieListItem(item = it) }
                }

                item {
                    if (movies.loadState.append is LoadState.Loading) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator(
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}