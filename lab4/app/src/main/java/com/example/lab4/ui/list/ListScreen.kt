package com.example.lab4.ui.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.lab3.components.MovieListItem
import com.example.lab4.data.models.Movie

@Composable
fun ListScreen(
    data: List<Movie>
) {
    LazyColumn(
        contentPadding = PaddingValues(all = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(items = data) { item ->
            MovieListItem(item = item)
        }
    }
}