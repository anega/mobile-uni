package com.example.lab2.components

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
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.lab2.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ApplicationDrawer(
    navController: NavHostController,
    currentRoute: String,
    drawerState: DrawerState,
    scope: CoroutineScope
) {
    ModalDrawerSheet {
        DrawerHeader()
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
}

@Composable
fun DrawerHeader() {
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
}