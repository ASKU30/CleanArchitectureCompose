package com.example.testdata.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import com.example.testdata.BuildConfig
import com.example.domain.model.Movie
import com.example.testdata.R

@Composable
fun MovieListItem(movie: Movie, navController: NavHostController) {
    Card(
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(8.dp),

        ) {
        Row(
            modifier = Modifier
                .height(IntrinsicSize.Max)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            movie.posterPath?.let {
                Image(
                    modifier = Modifier
                        .padding(
                            end = 4.dp,
                        )
                        .width(120.dp),
                    painter = rememberAsyncImagePainter(
                        ImageRequest.Builder(LocalContext.current)
                            .data(data = BuildConfig.POSTER_URL + movie.posterPath).apply(block = fun ImageRequest.Builder.() {
                                crossfade(true)
                                scale(Scale.FILL)
                            }).build()
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
            Column(Modifier.height(IntrinsicSize.Max)) {
                movie.title?.let { Text(text = it, style = MaterialTheme.typography.headlineMedium) }
                Spacer(modifier = Modifier.height(4.dp))
                movie.overview?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.headlineMedium,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_star_rate),
                        contentDescription = null
                    )
                    movie.rating?.let {
                        Text(text = it, style = MaterialTheme.typography.headlineSmall)
                    }
                }
                Spacer(modifier = Modifier.height(4.dp))
            }
        }
    }
}