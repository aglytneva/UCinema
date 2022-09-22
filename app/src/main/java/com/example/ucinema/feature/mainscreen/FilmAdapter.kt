package com.example.ucinema.feature.mainscreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.ucinema.R
import com.example.ucinema.feature.domain.FilmModel

class FilmAdapter ()
    : RecyclerView.Adapter<FilmAdapter.ViewHolder>() {

    private var filmData: List<FilmModel> =emptyList()

    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val tvTittle: TextView
        val imageFilm:ImageView
        val tvGenre:TextView
        val tvPopularity:TextView
        init {
            tvTittle = view.findViewById(R.id.tvTittle)
            imageFilm= view.findViewById(R.id.ivImageFilm)
            tvGenre= view.findViewById(R.id.tvGenre)
            tvPopularity= view.findViewById(R.id.tvPopularity)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_film, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.tvTittle.text = filmData[position].original_title
        viewHolder.tvPopularity.text=filmData[position].popularity.toString()
        viewHolder.tvGenre.text= filmData[position].genres.map{it.name}.joinToString (" ")
        Glide
            .with(viewHolder.imageFilm)
            .load(filmData[position].poster_path)
            .placeholder(R.drawable.ic_baseline_animation_24)//картина пока загружается
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)//перезагрузка изображений, пока мы скроллим вверх-низ экран, есть еще ALL
            .centerInside()//растягивание изображения
            .transition(DrawableTransitionOptions.withCrossFade())//анимирование
            .error(R.drawable.ic_baseline_blur_on_24)//картинка если ошибка получения картинки
            .into(viewHolder.imageFilm)
    }
    override fun getItemCount() = filmData.size

    fun setData (film :List <FilmModel>) {
        filmData = film
        notifyDataSetChanged()

    }

}


