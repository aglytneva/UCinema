package com.example.ucinema.feature.di

import com.example.ucinema.feature.data.FilmApi
import com.example.ucinema.feature.data.FilmRepository
import com.example.ucinema.feature.data.FilmRepositoryImpl
import com.example.ucinema.feature.data.FilmsRemoteSourse
import com.example.ucinema.feature.domain.FilmsInteractor
import com.example.ucinema.feature.mainscreen.MainScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit



val mainScreenModule = module{

    single <FilmApi>{
        get<Retrofit>().create(FilmApi::class.java)
    }

    single <FilmsRemoteSourse> {
        FilmsRemoteSourse (api =get())
    }

    single<FilmRepository> {
        FilmRepositoryImpl(source = get())
    }

    single <FilmsInteractor> {
        FilmsInteractor(repository = get())
    }

    viewModel{
        MainScreenViewModel(get<FilmsInteractor>())
    }

}