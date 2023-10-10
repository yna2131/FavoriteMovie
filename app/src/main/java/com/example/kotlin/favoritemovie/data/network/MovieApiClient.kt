package com.example.kotlin.favoritemovie.data.network

import com.example.kotlin.favoritemovie.data.network.model.movie.Movie
import com.example.kotlin.favoritemovie.utils.Constants

/**
 * @brief This class is the client of the API
 * @author Yuna Chung A01709043
 * @date 2023.10.10
 * @version 1.0.0
 */

class MovieApiClient {
    private lateinit var api: MovieAPIService

    suspend fun getMovieList(limit:Int): com.example.kotlin.favoritemovie.data.network.model.MovieObject?{
        api = NetworkModuleDI()
        return try{
            api.getPopularMovieList(Constants.API_KEY, limit)
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
