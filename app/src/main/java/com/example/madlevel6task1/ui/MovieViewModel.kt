package com.example.madlevel6task1.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {

    private val movieRepository = MovieRepository()

    val movies: LiveData<MovieResult> = movieRepository.movies

    fun getMovies(language: String, releaseYear: Int) {
        viewModelScope.launch {
            // Invoke getMovies, then movies LiveData object will be updated
            // Observing views will get notified
            movieRepository.getMovies(language, releaseYear)
        }
    }

}