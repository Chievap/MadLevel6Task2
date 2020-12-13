package com.example.madlevel6task1.ui

import com.example.madlevel6task2.entity.Movie
import com.google.gson.annotations.SerializedName

class MovieResult {
    @SerializedName("results") var results = arrayListOf<Movie>()
}