package com.example.kotlin.favoritemovie.data.network

import com.example.kotlin.favoritemovie.data.network.model.movie.Movie
class MovieApiClient {
    private val apiService = MovieApiService()

    suspend fun getMovieList(limit:Int): com.example.kotlin.favoritemovie.data.network.model.MovieObject?{
        api = NetworkModuleDI()
        return try{
            api.getMovieList(limit)
        }catch (e:java.lang.Exception){
            e.printStackTrace()
            null
        }
    }

    suspend fun getMovieInfo(numberMovie:Int): Movie? {
        api = NetworkModuleDI()
        return try{
            api.getMovieInfo(numberMovie)
        }catch (e:java.lang.Exception){
            e.printStackTrace()
            null
        }
    }
}
