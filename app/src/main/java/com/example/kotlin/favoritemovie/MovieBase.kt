package com.example.kotlin.favoritemovie

import com.google.gson.annotations.SerializedName
data class MovieBase(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String,
)
