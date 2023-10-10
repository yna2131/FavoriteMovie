package com.example.kotlin.favoritemovie.domain

import com.example.kotlin.favoritemovie.data.MovieRepository
import com.example.kotlin.favoritemovie.data.network.model.movie.Movie

/**
 * @brief Clase que se encarga de obtener la información de una película
 * @author Yuna Chung A01709043
 * @date 2023.10.10
 * @version 1.0.0
 */
class MovieInfoRequirement {
    private val repository = MovieRepository()

    suspend operator fun invoke(
        numberMovie:Int
    ): Movie? = repository.getMovieInfo(numberMovie)
}