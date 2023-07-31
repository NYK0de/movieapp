package com.example.movieapp.ui.composables

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.domain.common.MovieResult
import com.example.domain.models.MovieUI
import com.example.movieapp.ui.viewmodels.MovieViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MovieMainView(
    viewModel: MovieViewModel,
    onClickItem: (item: MovieUI) -> Unit
) {

    val listState = rememberLazyListState()
    val theList = viewModel.listMovies.observeAsState()

   Scaffold(
         topBar = {
             TopAppBar(
                 backgroundColor = MaterialTheme.colors.primary
             ) {
                 Text(text = "AppName")
             }
         },
         content = {  _ ->
             BoxWithConstraints(
                 modifier = Modifier
                     .fillMaxSize()
             ) {

                 LaunchedEffect(key1 = viewModel){
                     // call to load data
                     viewModel.getListOfMovies()
                 }

                 when( theList.value ){
                     is MovieResult.Loading -> {
                         LoadingView()
                     }
                     is MovieResult.Success -> {
                         val data = (theList.value as MovieResult.Success).data
                         val movies = if (data.movies.isNotEmpty()) data.movies else null

                         if (movies == null){
                             ErrorView(
                                 message = "There isn't movies"
                             )
                         }
                         else {
                             LazyColumn(
                                 state = listState,
                                 modifier = Modifier
                                     .fillMaxSize(),
                                 verticalArrangement = Arrangement.spacedBy(8.dp)
                             ) {
                                 items(
                                     items = data.movies,
                                 ) { item ->
                                     // ech item
                                     EachItemListView(
                                         item = item,
                                         onClickItem = {
                                             onClickItem(it)
                                         }
                                     )
                                 }
                             }
                         }
                     }
                     is MovieResult.Error -> {
                         val message = (theList.value as MovieResult.Error).error
                         ErrorView(
                             message = message.message
                         )
                     }
                 }

             }
         }
   )
}

@Composable
fun LoadingView() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorView(message: String){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = message, style = TextStyle(color = Color.Red))
    }
}

@OptIn(
    ExperimentalMaterialApi::class,
    ExperimentalGlideComposeApi::class, ExperimentalGlideComposeApi::class
)
@Composable
fun EachItemListView(
    item: MovieUI,
    onClickItem: (item : MovieUI) -> Unit,
) {
   //
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(horizontal = 4.dp),
        shape = RoundedCornerShape(4.dp),
        elevation = 8.dp,
        onClick = {
            onClickItem(item)
        }
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            ConstraintLayout {
                val (image, rightContent ) = createRefs()
                GlideImage(
                    model = "https://image.tmdb.org/t/p/w500/${item.posterPath}",
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .padding(all = 8.dp)
                        .clip(CircleShape)
                        .constrainAs(image) {
                            start.linkTo(parent.start)
                            top.linkTo(parent.top)
                        }
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight().fillMaxHeight().padding(8.dp)
                        .constrainAs(rightContent) {
                            start.linkTo(image.end)
                            top.linkTo(parent.top)
                        },
                    verticalArrangement = Arrangement.Top
                ) {
                    Text(
                        text = item.originalTitle ?: "title",
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(top = 8.dp, bottom = 8.dp)
                    )
                    Text(
                        text = "release date: ${item.releaseDate}",
                        fontSize = 12.sp,
                    )
                    Text(
                        text = "votes: ${item.voteCount}" ,
                        fontSize = 12.sp,
                    )
                }
            }
        }
    }
}