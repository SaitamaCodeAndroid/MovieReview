package com.example.moviereview.ui.presentation.home.tabs

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.moviereview.BuildConfig
import com.example.moviereview.data.service.response.MovieDetails
import com.example.moviereview.ui.theme.colorYellow

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TopUpMovieSection(movies: List<MovieDetails>) {
    val pagerState = rememberPagerState { movies.size }

    HorizontalPager(
        modifier = Modifier.padding(top = 8.dp),
        state = pagerState,
        beyondBoundsPageCount = 5,
    ) {
        val pageOffset = (pagerState.currentPage - it) + pagerState.currentPageOffsetFraction
        val imageSize by animateFloatAsState(
            targetValue = if (pageOffset != 0f) {
                0.75f
            } else {
                1f
            },
            animationSpec = tween(durationMillis = 300),
            label = "",
        )
        val imageUrl = "${BuildConfig.IMAGE_BASE_URL}${movies[it].posterPath}"
        MovieItem(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(16.dp))
                .graphicsLayer {
                    scaleX = imageSize
                    scaleY = imageSize
                },
            imageUrl = imageUrl,
        )
    }
}

@Composable
fun MovieCollectionSection(
    collectionName: String,
    movies: List<MovieDetails>,
) {
    Column(
        modifier = Modifier.padding(top = 32.dp)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 8.dp),
        ) {
            Text(
                text = collectionName,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Bottom),
                text = "See More",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorYellow
                ),
                textAlign = TextAlign.End,
            )
        }
        LazyRow(
            modifier = Modifier.padding(top = 8.dp),
            contentPadding = PaddingValues(
                start = 4.dp,
                end = 8.dp,
            ),
        ) {
            items(movies.size) {
                val imageUrl = "${BuildConfig.IMAGE_BASE_URL}${movies[it].posterPath}"
                MovieItem(
                    modifier = Modifier
                        .size(
                            width = 130.dp,
                            height = 180.dp
                        )
                        .clip(RoundedCornerShape(8.dp))
                        .padding(start = 4.dp),
                    imageUrl = imageUrl,
                )
            }
        }
    }
}

@Composable
fun MovieItem(
    modifier: Modifier = Modifier,
    imageUrl: String,
) {
    Card(
        modifier = modifier,
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .build(),
            contentDescription = "Image",
            contentScale = ContentScale.Crop
        )
    }
}


@Preview
@Composable
fun MovieItemPreview() {
    MovieItem(imageUrl = "1E5baAaEse26fej7uHcjOgEE2t2.jpg")
}

@Preview
@Composable
fun MovieSectionPreview() {
    MovieCollectionSection(
        collectionName = "Movie",
        movies = listOf(
            MovieDetails(
                id = 1,
                posterPath = "1E5baAaEse26fej7uHcjOgEE2t2.jpg",
                voteAverage = 5.0,
            ),
            MovieDetails(
                id = 1,
                posterPath = "1E5baAaEse26fej7uHcjOgEE2t2.jpg",
                voteAverage = 5.0,
            ),
            MovieDetails(
                id = 1,
                posterPath = "1E5baAaEse26fej7uHcjOgEE2t2.jpg",
                voteAverage = 5.0,
            )
        )
    )
}