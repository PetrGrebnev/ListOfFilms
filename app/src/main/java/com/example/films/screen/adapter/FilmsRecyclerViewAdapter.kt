package com.example.films.screen.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.films.databinding.ItemElementFilmsBinding
import com.example.films.models.Film

class FilmsRecyclerViewAdapter(
    private val onClick: (nameFilm: String) -> Unit,
) : RecyclerView.Adapter<FilmViewHolder>() {

    private var listFilms = mutableListOf<Film>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        return FilmViewHolder(ItemElementFilmsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        listFilms[position].let { film ->
            holder.bind(film)
            holder.itemView.setOnClickListener {
                onClick(film.title?: "Unknown film")
            }
        }
    }

    override fun getItemCount(): Int = listFilms.size

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<Film>) {
        this.listFilms = list as MutableList<Film>
        notifyDataSetChanged()
    }

}