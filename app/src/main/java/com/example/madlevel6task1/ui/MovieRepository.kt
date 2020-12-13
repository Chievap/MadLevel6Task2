package com.example.madlevel6task1.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MovieRepository {
    private val movieApiService = MovieApi.createApi()

    private val _movies: MutableLiveData<MovieResult> = MutableLiveData()

    val movies: LiveData<MovieResult>
        get() = _movies

    suspend fun getMovies(language: String, releaseYear: Int) {
        val movieList = movieApiService.getMovies(language, releaseYear)
        _movies.value = movieList
    }
}