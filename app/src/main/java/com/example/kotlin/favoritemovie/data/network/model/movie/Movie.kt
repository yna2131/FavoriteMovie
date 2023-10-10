package com.example.kotlin.favoritemovie.data.network.model.movie

data class Movie(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)