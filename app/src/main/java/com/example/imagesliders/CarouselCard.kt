package com.example.imagesliders

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Scale

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CarouselCard() {
    val pagerState = rememberPagerState(initialPage = 2)
    val sliderList = listOf(
        "https://picsum.photos/id/240/500/800",
        "https://picsum.photos/id/241/500/800",
        "https://picsum.photos/id/242/500/800",
        "https://picsum.photos/id/243/500/800",
        "https://picsum.photos/id/244/500/800",
        "https://picsum.photos/id/245/500/800"
    )

    Column(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(
            pageCount = sliderList.size,
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 65.dp),
            modifier = Modifier
                .height(350.dp)
        ) { page ->
            Card(
                shape = RoundedCornerShape(10.dp)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(sliderList[page])
                        .crossfade(true)
                        .scale(Scale.FILL)
                        .build(),
                    contentDescription = null
                )

            }

        }

    }
}