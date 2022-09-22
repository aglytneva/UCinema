package com.example.ucinema.feature.data.model

import com.google.gson.annotations.SerializedName

data class FilmsPageRemoteModel(
    val page: Int,
    @SerializedName("results")
    val filmsList: List<FilmRemoteModel>,
    val total_pages: Int,
    val total_results: Int
)