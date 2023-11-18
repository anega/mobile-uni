package com.example.lab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab2.ui.theme.Lab2Theme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    private lateinit var drawerState: DrawerState;
    private lateinit var scope: CoroutineScope;

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab2Theme {
                drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                scope = rememberCoroutineScope();
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ModalNavigationDrawer(
                        drawerState = drawerState,
                        drawerContent = {
                            ModalDrawerSheet {
                                Text(text = "Drawer content")
                                Text(text = "Drawer content")
                                Text(text = "Drawer content")
                                Text(text = "Drawer content")
                            }
                        }) {
                        Scaffold(
                            topBar = {
                                TopAppBar(
                                    title = { Text(text = "TopAppBar") },
                                    modifier = Modifier.fillMaxWidth(),
                                    colors = TopAppBarDefaults.smallTopAppBarColors(
                                        containerColor = MaterialTheme.colorScheme.primaryContainer
                                    ),
                                    navigationIcon = {
                                        IconButton(
                                            onClick = { scope.launch { drawerState.open() }},
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
                            Text(
                                text = "Screen content (Drawer composable body)",
                                modifier = Modifier.padding(it)
                            )
                        }
                    }
                }
            }
        }
    }
}
