package com.example.kotlin.favoritemovie.data.network.model

import com.google.gson.annotations.SerializedName
data class MovieObject(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val results: ArrayList<MovieBase>,
)
