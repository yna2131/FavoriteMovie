package com.example.kotlin.favoritemovie.data.network

import com.example.kotlin.favoritemovie.data.network.model.MovieObject
import com.example.kotlin.favoritemovie.data.network.model.movie.Movie
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query
interface MovieAPIService {

    // https://api.themoviedb.org/3/movie/popular/
    @GET("movie/popular")
    suspend fun getPopularMovieList(
        @Header("Authorization") apiKey: String,
        @Query("limit") limit: Int
    ): MovieObject

    // https://api.themoviedb.org/3/movie/{movie_id}
    @GET("movie/{movieId}")
    suspend fun getMovieInfo(
        @Path("movieId") movieId: Int
    ): Movie
}