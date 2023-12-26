package com.example.lab4.ui.movie

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.lab4.ui.UiEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieScreen(
    navController: NavHostController,
    viewModel: MovieViewModel = hiltViewModel()
) {
    var openDialog by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()
    val confirmEnabled = remember {
        derivedStateOf { datePickerState.selectedDateMillis != null }
    }

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                UiEvent.PopBackStack -> navController.popBackStack()
            }
        }
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { viewModel.onEvent(AddEditMovieEvent.OnSaveMovie) }
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
            if (openDialog) {
                DatePickerDialog(
                    onDismissRequest = { openDialog = false },
                    confirmButton = {
                        TextButton(
                            onClick = {
                                viewModel
                                    .onEvent(AddEditMovieEvent.OnReleaseDateChange(datePickerState.selectedDateMillis!!))
                                openDialog = false
                            },
                            enabled = confirmEnabled.value
                        ) {
                            Text("OK")
                        }
                    },
                    dismissButton = {
                        TextButton(
                            onClick = { openDialog = false }
                        ) {
                            Text("Cancel")
                        }
                    }
                ) {
                    DatePicker(state = datePickerState)
                }
            }
            OutlinedTextField(
                value = viewModel.releaseDate,
                onValueChange = {},
                Modifier
                    .fillMaxWidth()
                    .onFocusEvent {
                        if (it.isFocused) {
                            openDialog = true
                        }
                    },
                label = { Text("Date") },
                readOnly = true
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
