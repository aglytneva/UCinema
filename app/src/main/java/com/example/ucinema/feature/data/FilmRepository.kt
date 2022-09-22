package com.example.ucinema.feature.data

import com.example.ucinema.feature.domain.FilmModel

interface FilmRepository {
    suspend fun getFilms ():List<FilmModel>
}

