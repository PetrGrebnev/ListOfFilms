package com.example.films.network

import com.example.films.models.ItemFilms
import retrofit2.Response
import retrofit2.http.GET

interface GetJsonFilm {

    @GET("films.json")
    suspend fun getFilms(): Response<ItemFilms>

}