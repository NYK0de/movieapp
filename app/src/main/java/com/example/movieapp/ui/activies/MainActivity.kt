package com.example.movieapp.ui.activies

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.domain.models.MovieUI
import com.example.movieapp.ui.composables.MovieMainView
import com.example.movieapp.ui.theme.MovieAppTheme
import com.example.movieapp.ui.viewmodels.MovieViewModel
import com.example.movieapp.utils.toJson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val movieViewModel : MovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MovieMainView(
                        viewModel = movieViewModel,
                        onClickItem = {
                            showDetails(it)
                        }
                    )
                }
            }
        }
    }

    private fun showDetails(movieUI: MovieUI) {
        val intent = Intent(applicationContext, DetailActivity::class.java)
        intent.putExtra("info", movieUI.toJson())
        startActivity(intent)
    }


}
