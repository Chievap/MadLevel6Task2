package com.example.madlevel6task1.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.madlevel6task2.entity.Movie

class SharedViewModel: ViewModel() {
    private var _selectedMovie: MutableLiveData<Movie> = MutableLiveData()

    val selectedMovie: LiveData<Movie>
        get() = _selectedMovie

    fun select(movie: Movie) {
        _selectedMovie.value = movie
    }
}