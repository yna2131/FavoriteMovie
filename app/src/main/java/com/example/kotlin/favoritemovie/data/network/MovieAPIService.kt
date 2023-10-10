package com.example.kotlin.favoritemovie.data.network

import com.example.kotlin.favoritemovie.data.network.model.movie.Movie
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
interface MovieAPIService {

    // https://api.themoviedb.org/3/movie/popular
    @GET("movie/popular")
    suspend fun getPopularMovieList(
        @Querry("limit") limit: Int
    ): MovieObject
}