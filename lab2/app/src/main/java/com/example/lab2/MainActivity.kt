package com.example.lab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.lab2.components.ApplicationDrawer
import com.example.lab2.components.ApplicationTopBar
import com.example.lab2.screens.GalleryScreen
import com.example.lab2.screens.HomeScreen
import com.example.lab2.screens.SlideshowScreen
import com.example.lab2.ui.theme.Lab2Theme
import kotlinx.coroutines.CoroutineScope

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    private lateinit var drawerState: DrawerState
    private lateinit var scope: CoroutineScope
    private lateinit var navController: NavHostController

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab2Theme {
                drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                scope = rememberCoroutineScope()
                navController = rememberNavController()
                val currentNavBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = currentNavBackStackEntry?.destination?.route ?: "home"
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
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
                            }
                        }
                    }
                }
            }
        }
    }
}
