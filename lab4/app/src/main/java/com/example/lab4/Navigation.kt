package com.example.lab4

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.lab4.ui.list.ListScreen
import com.example.lab4.ui.movie.MovieScreen

@Composable
fun Navigation(
    navController: NavHostController
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
        ) {
            MovieScreen()
        }
    }
}