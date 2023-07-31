package com.example.movieapp.ui.viewmodels

import android.view.View
import androidx.lifecycle.*
import androidx.lifecycle.MutableLiveData
import com.example.domain.common.MovieResult
import com.example.domain.models.MovieResponseUI
import com.example.domain.usecases.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val useCase : MovieUseCase
) : ViewModel() {

    private val _listMovies = MutableLiveData<MovieResult<MovieResponseUI>>()
    val listMovies : LiveData<MovieResult<MovieResponseUI>> = _listMovies

    fun getListOfMovies(){
        viewModelScope.launch{
            useCase.getMovies().collectLatest {
                _listMovies.value = it
            }
        }
    }

}