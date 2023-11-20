package com.example.lab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.lab2.screens.GalleryScreen
import com.example.lab2.screens.HomeScreen
import com.example.lab2.screens.SlideshowScreen
import com.example.lab2.ui.theme.Lab2Theme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

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
                            ModalDrawerSheet {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(bottom = 8.dp)
                                        .background(MaterialTheme.colorScheme.primaryContainer)
                                        .padding(20.dp)
                                ) {
                                    Box(
                                        contentAlignment = Alignment.Center,
                                        modifier = Modifier
                                            .padding(bottom = 8.dp)
                                            .size(80.dp)
                                            .clip(CircleShape)
                                    ) {
                                        Image(
                                            painter = painterResource(R.drawable.ic_launcher_background),
                                            contentDescription = "Android icon background",
                                            contentScale = ContentScale.FillBounds,
                                            modifier = Modifier.fillMaxSize()
                                        )
                                        Icon(
                                            painter = painterResource(id = R.drawable.ic_launcher_foreground),
                                            contentDescription = "Android icon",
                                            tint = Color.White,
                                        )
                                    }
                                    Text(
                                        text = "Android Studio",
                                        color = MaterialTheme.colorScheme.onPrimaryContainer
                                    )
                                    Text(
                                        text = "android.studio@android.com",
                                        fontSize = 12.sp,
                                        color = MaterialTheme.colorScheme.onPrimaryContainer
                                    )
                                }
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(horizontal = 4.dp)
                                ) {
                                    NavigationDrawerItem(
                                        modifier = Modifier.padding(horizontal = 4.dp),
                                        label = {
                                            Row {
                                                Icon(
                                                    painter = painterResource(id = R.drawable.ic_photo_camera),
                                                    contentDescription = "Home screen",
                                                    modifier = Modifier.padding(end = 12.dp)
                                                )
                                                Text(text = "Home")
                                            }
                                        },
                                        selected = currentRoute == "home",
                                        onClick = {
                                            navController.navigate("home") {
                                                popUpTo("home")
                                            }
                                            scope.launch { drawerState.close() }
                                        })
                                    NavigationDrawerItem(
                                        label = {
                                            Row {
                                                Icon(
                                                    painter = painterResource(id = R.drawable.ic_menu_gallery),
                                                    contentDescription = "Gallery screen icon",
                                                    modifier = Modifier.padding(end = 12.dp)
                                                )
                                                Text(text = "Gallery")
                                            }
                                        },
                                        selected = currentRoute == "gallery",
                                        onClick = {
                                            navController.navigate("gallery") {
                                                launchSingleTop = true
                                                restoreState = true
                                            }
                                            scope.launch { drawerState.close() }
                                        })
                                    NavigationDrawerItem(
                                        label = {
                                            Row {
                                                Icon(
                                                    painter = painterResource(id = R.drawable.ic_menu_gallery),
                                                    contentDescription = "Gallery screen icon",
                                                    modifier = Modifier.padding(end = 12.dp)
                                                )
                                                Text(text = "Slideshow")
                                            }
                                        },
                                        selected = currentRoute == "slideshow",
                                        onClick = {
                                            navController.navigate("slideshow") {
                                                launchSingleTop = true
                                                restoreState = true
                                            }
                                            scope.launch { drawerState.close() }
                                        }
                                    )
                                }
                            }
                        }) {
                        Scaffold(
                            topBar = {
                                TopAppBar(
                                    title = { Text(text = currentRoute.replaceFirstChar { it.uppercase() }) },
                                    modifier = Modifier.fillMaxWidth(),
                                    colors = TopAppBarDefaults.smallTopAppBarColors(
                                        containerColor = MaterialTheme.colorScheme.primaryContainer
                                    ),
                                    navigationIcon = {
                                        IconButton(
                                            onClick = { scope.launch { drawerState.open() } },
                                            content = {
                                                Icon(
                                                    imageVector = Icons.Default.Menu,
                                                    contentDescription = null
                                                )
                                            }
                                        )
                                    }
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
