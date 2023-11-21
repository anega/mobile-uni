package com.example.lab2.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.activity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.lab2.TabbedActivity
import com.example.lab2.components.ApplicationDrawer
import com.example.lab2.components.ApplicationTopBar
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppScreen() {
    val drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope: CoroutineScope = rememberCoroutineScope()
    val navController: NavHostController = rememberNavController()
    val currentNavBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentNavBackStackEntry?.destination?.route ?: "home"

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ApplicationDrawer(
                navController = navController,
                currentRoute = currentRoute,
                drawerState = drawerState,
                scope = scope
            )
        }) {
        Scaffold(
            topBar = {
                ApplicationTopBar(
                    currentRoute = currentRoute,
                    drawerState = drawerState,
                    scope = scope
                )
            }
        ) {
            NavHost(
                navController = navController,
                startDestination = "home",
                modifier = Modifier.padding(it)
            ) {
                composable("home") {
                    HomeScreen()
                }
                composable("gallery") {
                    GalleryScreen()
                }
                composable("slideshow") {
                    SlideshowScreen()
                }
                composable("customScreen") {
                    MyCustomScreen()
                }
                activity(route = "tabbedActivity") {
                    this.activityClass = TabbedActivity::class
                }
            }
        }
    }
}