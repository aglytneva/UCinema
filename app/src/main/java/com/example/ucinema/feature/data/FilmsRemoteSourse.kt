package com.example.ucinema.feature.data

import com.example.ucinema.feature.data.model.FilmsPageRemoteModel

class FilmsRemoteSourse (private val api : FilmApi) {
    suspend fun getFilms () : FilmsPageRemoteModel {
        return api.getFilms()
    }
}
