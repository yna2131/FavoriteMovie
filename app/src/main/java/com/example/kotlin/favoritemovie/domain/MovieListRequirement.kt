package com.example.kotlin.favoritemovie.domain

import com.example.kotlin.favoritemovie.data.MovieRepository
import com.example.kotlin.favoritemovie.data.network.model.MovieObject

/**
 * @brief Class that implements the repository pattern to get the data from the API
 * @author Yuna Chung A01709043
 * @date 2023.10.10
 * @version 1.0.0
 */

class MovieListRequirement {

    private val repository = MovieRepository()

    suspend operator fun invoke(
        limit:Int
    ): MovieObject? = repository.getMovieList(limit)
}