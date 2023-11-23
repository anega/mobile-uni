package com.example.lab3.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.lab3.R
import com.example.lab3.models.Movie

@Composable
fun MovieListItem(item: Movie) {
    ElevatedCard(
        shape = RoundedCornerShape(4.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Row {
            Box {
                AsyncImage(
                    model = item.posterPath,
                    placeholder = painterResource(id = R.drawable.ic_videocam),
                    error = painterResource(id = R.drawable.ic_videocam),
                    contentDescription = item.title,
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .width(94.dp)
                        .fillMaxHeight()
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_videocam),
                    contentDescription = "Movie icon",
                    tint = MaterialTheme.colorScheme.primaryContainer,
                    modifier = Modifier.offset(x = 4.dp)
                )
            }
            Column(
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 20.dp)
            ) {
                Text(
                    text = item.title,
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = item.releaseDate,
                    color = Color(0xFF999999),
                    fontSize = 14.sp,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = item.overview,
                    fontSize = 14.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
@Preview
fun ListItemPreview() {
    MovieListItem(
        item = Movie(
            id = 872585,
            posterPath = "https://image.tmdb.org/t/p/w154/8Gxv8gSFCU0XGDykEGv7zR1n2ua.jpg",
            title = "Oppenheimerkjshdfkjashkdfhaskdfhaksdjfhaksdfh",
            overview = "The story of J. Robert Oppenheimer's role in the development of the atomic bomb during World War II.",
            mediaType = "movie",
            releaseDate = "2023-07-19",
            voteAverage = 8.178,
            voteCount = 4751
        )
    )
}