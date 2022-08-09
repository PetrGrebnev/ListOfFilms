package com.example.films.models

data class Film(
    var actors: List<Actor>?,
    var directorName: String?,
    val releaseYear: Int?,
    val title: String?,
)