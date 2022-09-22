package com.example.ucinema.feature.mainscreen

import com.example.ucinema.base.Event
import com.example.ucinema.feature.domain.FilmModel

data class ViewState(
    var filmList: List<FilmModel>
)

sealed class UiEvent : Event {

}
sealed class DataEvent : Event {
    object loadFilms :DataEvent()
    data class onLoadFilmSoursed ( val films: List<FilmModel>) : DataEvent()
    data class OnFailedFilmLoaded ( val throwable: Throwable) : DataEvent()
}
