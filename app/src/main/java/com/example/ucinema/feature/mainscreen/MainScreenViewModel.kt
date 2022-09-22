package com.example.ucinema.feature.mainscreen

import androidx.lifecycle.viewModelScope
import com.example.ucinema.base.BaseViewModel
import com.example.ucinema.base.Event
import com.example.ucinema.feature.domain.FilmsInteractor
import kotlinx.coroutines.launch

class MainScreenViewModel(private val interactor: FilmsInteractor) : BaseViewModel<ViewState>() {

    init {
        processDataEvent(DataEvent.loadFilms)
    }

    override fun initialViewState() = ViewState(
        filmList = emptyList()
    )

    override fun reduce(event: Event, previousSTATE: ViewState): ViewState? {
        when (event) {
            is DataEvent.loadFilms -> {
                viewModelScope.launch {
                    interactor.getFilms().fold(
                        onError = {

                        },
                        onSuccess = {
                            processDataEvent((DataEvent.onLoadFilmSoursed(it)))
                        }
                    )
                }
                return previousSTATE
            }

            is DataEvent.onLoadFilmSoursed -> {
                return previousSTATE.copy(
                    filmList = event.films
                )
            }
            else -> return null
        }
    }
}