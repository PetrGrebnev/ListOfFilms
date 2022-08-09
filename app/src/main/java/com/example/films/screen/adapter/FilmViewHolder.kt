package com.example.films.screen.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.example.films.databinding.ItemElementFilmsBinding
import com.example.films.models.Actor
import com.example.films.models.Film
import com.example.films.utils.getActor

class FilmViewHolder(
    private val binding: ItemElementFilmsBinding,
) : RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("SetTextI18n")
    fun bind(item: Film) {
        binding.apply {
            nameFilm.text = item.title + "(${item.releaseYear})"
            nameDirector.text = "Режиссер: ${item.directorName}"
            fullNameActors.text = getActor(item.actors ?:
            listOf(Actor("Bad actor"), Actor("good actor")))
        }
    }
}
