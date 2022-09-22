package com.example.ucinema.feature.domain

import attempt
import com.example.ucinema.feature.data.FilmRepository
import com.google.gson.Gson

class FilmsInteractor (private val repository:FilmRepository){
    val gson = Gson()
    suspend fun getFilms () = attempt { repository.getFilms() }
}

