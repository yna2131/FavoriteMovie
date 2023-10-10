package com.example.kotlin.favoritemovie.domain

import com.example.kotlin.favoritemovie.data.MovieRepository
import com.example.kotlin.favoritemovie.data.network.model.movie.Movie

class MovieInfoRequirement {
    private val repository = MovieRepository()

    suspend operator fun invoke(
        numberMovie:Int
    ): Movie? = repository.getMovieInfo(numberMovie)
}