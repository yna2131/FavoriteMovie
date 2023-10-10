package com.example.kotlin.favoritemovie.data

import com.example.kotlin.favoritemovie.data.network.MovieAPIService
import com.example.kotlin.favoritemovie.data.network.NetworkModuleDI
import com.example.kotlin.favoritemovie.data.network.model.MovieObject
import com.example.kotlin.favoritemovie.data.network.model.movie.Movie

class MovieRepository() {
    private lateinit var api:MovieAPIService

    suspend fun getMovieList(limit:Int):MovieObject?{
        api = NetworkModuleDI()
        return try{
            api.getPopularMovieList(limit)
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