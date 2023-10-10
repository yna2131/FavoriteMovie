package com.example.kotlin.favoritemovie.data.network

import com.example.kotlin.favoritemovie.data.network.model.MovieObject
import com.example.kotlin.favoritemovie.data.network.model.movie.Movie
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
interface MovieAPIService {

    // https://api.themoviedb.org/3/movie/popular
    @GET("movie/popular")
    suspend fun getPopularMovieList(
        @Query("limit") limit: Int
    ): MovieObject

    // https://api.themoviedb.org/3/movie/{movie_id}
    @GET("movie/{movie_id}")
    suspend fun getMovieInfo(
        @Path("movie_id") movie_id: Int
    ): Movie
}