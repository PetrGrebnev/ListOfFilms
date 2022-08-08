package com.example.films.utils

import com.example.films.models.Actor
import com.example.films.models.Film

fun dateSort(list: MutableList<Film>): List<Film> {
    var interval = 1
    var insertedFilm: Film
    var insertedIndex: Int
    while (interval < list.size / 3) {
        interval = 3 * interval + 1
    }
    while (interval > 0) {
        for (i in interval until list.size) {
            insertedFilm = list[i]
            insertedIndex = i

            while (insertedIndex >= interval && insertedFilm.releaseYear < list[insertedIndex - interval].releaseYear) {
                list[insertedIndex] = list[insertedIndex - interval]
                insertedIndex -= interval
            }

            list[insertedIndex] = insertedFilm
        }
        interval = (interval - 1) / 3
    }
    return list
}

fun fullNameDirector(list: MutableList<Film>): List<Film> {
    list.indices.forEach {
        var name = list[it].directorName
        val nameList = name.split(" ").reversed()
        nameList.indices.forEach { i ->
            if (i > 0) {
                name += "${nameList[i][0]}."
            } else {
                name = nameList[i] + " "
            }
        }
        list[it].directorName = name
        list[it].actors = duplicateDeletion(list[it].actors as MutableList<Actor>)
    }
    return list
}

fun duplicateDeletion(list: MutableList<Actor>): List<Actor> {
    val mapActors = mutableSetOf<Actor>()
    (list.indices).forEach { actor ->
        mapActors.add(list[actor])
    }
    val newList = mutableListOf<Actor>()
    for (i in 0 until mapActors.size) {
        newList.add(mapActors.elementAt(i))
    }
    mapActors.clear()
    return newList
}

fun getActor(list: List<Actor>): String {
    var str = "Актеры: "
    (list.indices).forEach {
        str += "${list[it].actorName}, "
    }
    return str
}