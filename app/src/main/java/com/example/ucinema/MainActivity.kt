package com.example.ucinema

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.ucinema.feature.mainscreen.DataEvent
import com.example.ucinema.feature.mainscreen.FilmAdapter
import com.example.ucinema.feature.mainscreen.MainScreenViewModel
import com.example.ucinema.feature.mainscreen.ViewState
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private val viewModel: MainScreenViewModel by viewModel()
//    private lateinit var binding: ActivityMainBinding
//    val adapter = FilmAdapter()
    val recyclerView:RecyclerView by lazy { findViewById(R.id.rvFilms) }
    private val adapter: FilmAdapter by lazy {
        FilmAdapter()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)


        recyclerView.adapter = adapter

        viewModel.viewState.observe (this, ::render)

        viewModel.processUiEvent(DataEvent.loadFilms)
    }

    private fun render (viewState: ViewState) {
        adapter.setData(viewState.filmList)

    }

}