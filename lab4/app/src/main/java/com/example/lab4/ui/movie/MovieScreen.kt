package com.example.lab4.ui.movie

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MovieScreen(
    viewModel: MovieViewModel = hiltViewModel()
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Default.Done,
                    contentDescription = "Save button"
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            Text(
                text = viewModel.screenTitle,
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(12.dp))
            OutlinedTextField(
                value = viewModel.title,
                label = { Text(text = "Title") },
                singleLine = true,
                onValueChange = {
                    viewModel.onEvent(AddEditMovieEvent.OnTitleChange(it))
                },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = viewModel.posterPath,
                label = { Text(text = "Poster URL") },
                singleLine = true,
                onValueChange = {
                    viewModel.onEvent(AddEditMovieEvent.OnPosterPathChange(it))
                },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = viewModel.overview,
                label = { Text(text = "Overview") },
                onValueChange = {
                    viewModel.onEvent(AddEditMovieEvent.OnOverviewChange(it))
                },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = viewModel.releaseDate,
                label = { Text(text = "Release date") },
                singleLine = true,
                onValueChange = {
                    viewModel.onEvent(AddEditMovieEvent.OnReleaseDateChange(it))
                },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = viewModel.voteAverage,
                label = { Text(text = "Average score") },
                singleLine = true,
                onValueChange = {
                    viewModel.onEvent(AddEditMovieEvent.OnVoteAverageChange(it))
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
