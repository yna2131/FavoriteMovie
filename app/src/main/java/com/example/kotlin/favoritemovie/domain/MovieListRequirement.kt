package com.example.kotlin.favoritemovie.domain

import com.example.kotlin.favoritemovie.data.MovieRepository
import com.example.kotlin.favoritemovie.data.network.model.MovieObject

class MovieListRequirement {

    private val repository = MovieRepository()

    suspend operator fun invoke(
        limit:Int
    ): MovieObject? = repository.getMovieList(limit)
}