package com.example.lab3.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.lab3.models.Data.Person

@Composable
fun PersonListItem(item: Person) {
    ElevatedCard(
        shape = RoundedCornerShape(4.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Box {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Person icon",
                tint = MaterialTheme.colorScheme.primaryContainer,
                modifier = Modifier.offset(x = 4.dp, y = 4.dp)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 20.dp)
            ) {
                AsyncImage(
                    model = item.profilePath,
                    placeholder = painterResource(id = R.drawable.ic_person),
                    error = painterResource(id = R.drawable.ic_person),
                    contentDescription = item.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(80.dp)
                        .height(80.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primaryContainer)
                )
                Text(
                    text = item.name,
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(top = 12.dp)
                )
                Text(
                    text = "Known for: ${item.knownForDepartment}",
                    color = Color(0xFF999999),
                    fontSize = 14.sp,
                    modifier = Modifier.padding(top = 4.dp)
                )
                Text(
                    text = "Famous movies: ${item.knownFor.joinToString()}",
                    color = Color.Black,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
        }
    }
}

@Composable
@Preview
fun PersonItemPreview() {
    PersonListItem(
        item = Person(
            id = 1373659,
            name = "Melissa Barrera",
            profilePath = "https://image.tmdb.org/t/p/w342/kJMecAOP5DEhJEQ6ScM23MfKPn3.jpg",
            mediaType = "person",
            gender = "female",
            knownForDepartment = "Acting",
            knownFor = arrayOf("Scream", "Scream VI", "Bed Rest")
        )
    )
}