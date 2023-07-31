package com.example.movieapp.utils

import com.example.domain.models.MovieUI
import com.google.gson.Gson

fun MovieUI.toJson() : String = Gson().toJson(this)

fun String.fromJson() : MovieUI = Gson().fromJson(this, MovieUI::class.java)