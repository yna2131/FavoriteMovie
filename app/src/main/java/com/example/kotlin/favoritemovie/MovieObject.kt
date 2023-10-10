package com.example.kotlin.favoritemovie

import com.google.gson.annotations.SerializedName
data class MovieObject(
    @SerializedName("name") val page: Int,
    @SerializedName("results") val results: ArrayList<MovieBase>,
)
