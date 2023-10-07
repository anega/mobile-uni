package com.example.lab1

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import java.util.Random

@Composable
fun MainScreen() {
    var quoteIndex by remember {
        mutableStateOf(0)
    }
    val context = LocalContext.current
    val quotes: Array<String> = context.resources.getStringArray(R.array.quotes)

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = quotes[quoteIndex])
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = {
                quoteIndex = Random().nextInt(quotes.size)
            }) {
                Text("Показати нову цитату")
            }
        }
    }
}