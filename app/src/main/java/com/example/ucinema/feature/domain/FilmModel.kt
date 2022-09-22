package com.example.ucinema.feature.domain

import com.example.ucinema.feature.data.model.Genre

data class FilmModel(

    val adult: Boolean?,
    val genres: List<Genre>,
    val id: Int?,
    val original_language: String?,
    val original_title: String?,

    val overview: String?,

    val popularity: Double?,

    val poster_path: String?,

    val release_date: String?,

    val title: String?,

    val video: String?,

    val vote_average: Double?,

    val vote_count: Int?
)