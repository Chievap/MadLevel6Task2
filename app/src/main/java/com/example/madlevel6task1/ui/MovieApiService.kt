package com.example.madlevel6task1.ui

import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {

    @GET(".")
    suspend fun getMovies(
        @Query("language") language: String,
        @Query("primary_release_year") releaseYear: Int
    ): MovieResult
}