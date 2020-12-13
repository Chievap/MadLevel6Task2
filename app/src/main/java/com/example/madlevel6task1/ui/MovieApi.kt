package com.example.madlevel6task1.ui

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieApi {
    companion object {
        private const val baseUrl = "https://api.themoviedb.org/"

        fun createApi(): MovieApiService {
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .addInterceptor { addApiKeyInterceptor(it) }
                .build()

            val movieApi = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return movieApi.create(MovieApiService::class.java)
        }

        private fun addApiKeyInterceptor(it: Interceptor.Chain): Response {
            val originalRequest = it.request()
            val originalHttpUrl = originalRequest.url

            val urlWithApiKey = originalHttpUrl.newBuilder()
                .addQueryParameter("api_key", "2c52436f452943aa30e1d0800c2eea40")
                .build()

            val requestWithApiKey = originalRequest.newBuilder()
                .url(urlWithApiKey)
                .build()

            return it.proceed(request = requestWithApiKey)
        }
    }
}