package com.example.lab4

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.lab4.ui.list.ListScreen
import com.example.lab4.ui.movie.AddEditMovieEvent
import com.example.lab4.ui.movie.MovieScreen
import com.example.lab4.ui.movie.MovieViewModel

@Composable
fun Navigation(
    navController: NavHostController,
    viewModel: MovieViewModel = hiltViewModel()
) {
    NavHost(
        navController = navController,
        startDestination = "list"
    ) {
        composable(
            route = "list"
        ) {
            ListScreen(navController = navController)
        }
        composable(
            route = "movie/{id}",
            arguments = listOf(navArgument("id") {
                type = NavType.IntType
            })
        ) { navBackStackEntry ->
            val currentMovieId = navBackStackEntry.arguments!!.getInt("id")
            LaunchedEffect(key1 = currentMovieId) {
                viewModel.onEvent(AddEditMovieEvent.OnIdChange(currentMovieId))
            }
            MovieScreen(navController = navController)
        }
    }
}