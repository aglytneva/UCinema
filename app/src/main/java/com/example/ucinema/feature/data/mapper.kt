package com.example.ucinema.feature.data

import com.example.ucinema.feature.data.model.FilmRemoteModel
import com.example.ucinema.feature.domain.FilmModel

fun FilmRemoteModel.toDomain() = FilmModel(

    adult = adult ,
    genres = genres ,
    id = id,
    original_language = original_language ,
    original_title = original_title ,
    overview = overview ,
    popularity = popularity,
    poster_path = poster_path ,
    release_date = release_date,
    title = title,
    video = video ,
    vote_average = vote_average,
    vote_count = vote_count
)