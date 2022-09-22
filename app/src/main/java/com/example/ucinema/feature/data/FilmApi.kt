package com.example.ucinema.feature.data

import com.example.ucinema.feature.data.model.FilmsPageRemoteModel
import retrofit2.http.GET

interface FilmApi {
    @GET("LukyanovAnatoliy/eca5141dedc79751b3d0b339649e06a3/raw/38f9419762adf27c34a3f052733b296385b6aa8d/movies.json")
    suspend fun getFilms(
    ): FilmsPageRemoteModel
}