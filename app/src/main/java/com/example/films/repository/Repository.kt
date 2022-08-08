package com.example.films.repository

import com.example.films.network.GetJsonFilm
import javax.inject.Inject

class Repository @Inject constructor(
    private val getJsonFilm: GetJsonFilm,
) {

    suspend fun getFilms() = getJsonFilm.getFilms()

}