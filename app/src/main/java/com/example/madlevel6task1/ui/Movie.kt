package com.example.madlevel6task2.entity

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("backdrop_path") var backDropImageRelativePath: String,
    @SerializedName("poster_path") var posterImageRelativePath: String,
    @SerializedName("title") var title: String,
    @SerializedName("release_date") var releaseDate: String,
    @SerializedName("vote_average") var rating: Float,
    @SerializedName("overview") var overview: String
) {

    fun getBackdropImageUrl() = "https://image.tmdb.org/t/p/original/$backDropImageRelativePath"

    fun getPosterImageUrl() = "https://image.tmdb.org/t/p/w200/$posterImageRelativePath"

}

enum class MovieLanguage(val language: String) {
    EnglishUS("en-US")
}