package com.example.movieapp.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.domain.models.MovieUI

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DetailView(item: MovieUI){
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(text = "${item.originalTitle}" , style = MaterialTheme.typography.body1)
            Spacer(modifier = Modifier.fillMaxWidth().height(16.dp))
            GlideImage(
                model = "https://image.tmdb.org/t/p/w500/${item.posterPath}",
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .width(400.dp)
                    .height(600.dp)
                    .padding(all = 8.dp)
                    .clip(RoundedCornerShape(20.dp))
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(top = 16.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "released: ${item.releaseDate}", fontSize = 14.sp)
                Text(text = "votes: ${item.voteCount}", fontSize = 14.sp)
            }
            Spacer(modifier = Modifier.fillMaxWidth().height(16.dp))
            Text(text = "${item.overview}", fontSize = 12.sp, maxLines = 3)
        }
    }
}