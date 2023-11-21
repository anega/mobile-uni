package com.example.lab2.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.lab2.screens.tabs.AnotherScreen
import com.example.lab2.screens.tabs.ArchiveScreen
import com.example.lab2.screens.tabs.PostScreen

@Composable
fun TabbedScreen() {
    var tabIndex by remember { mutableIntStateOf(0) }

    val tabs = listOf("Posts", "Another", "Archive")

    Column(modifier = Modifier.fillMaxWidth()) {
        ScrollableTabRow(selectedTabIndex = tabIndex) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title) },
                    selected = tabIndex == index,
                    onClick = { tabIndex = index },
                    icon = {
                        when (index) {
                            0 -> Icon(
                                imageVector = Icons.Default.List,
                                contentDescription = "Posts tab"
                            )

                            1 -> Icon(
                                imageVector = Icons.Default.Info,
                                contentDescription = "Another tab"
                            )

                            2 -> Icon(
                                imageVector = Icons.Default.DateRange,
                                contentDescription = "Archive tab"
                            )
                        }
                    }
                )
            }
        }
        when (tabIndex) {
            0 -> PostScreen()
            1 -> AnotherScreen()
            2 -> ArchiveScreen()
        }
    }
}