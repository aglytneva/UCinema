package com.example.ucinema.feature.data

import com.example.ucinema.feature.domain.FilmModel

class FilmRepositoryImpl (private val source: FilmsRemoteSourse) : FilmRepository {

    override suspend fun getFilms(): List<FilmModel> {
        return source.getFilms().filmsList.asSequence()
            .map{it.toDomain()}
            .toList()

    }

}
