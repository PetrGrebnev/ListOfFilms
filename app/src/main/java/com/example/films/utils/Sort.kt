package com.example.films.utils

import com.example.films.models.Actor
import com.example.films.models.Film

fun dateSort(list: MutableList<Film>): List<Film> {
    list.sortBy {
        it.releaseYear
    }
    return list
}

fun fullNameDirector(list: MutableList<Film>): List<Film> {
    list.indices.forEach {
//        var nameOne = list[it].directorName?.substringAfterLast(" ")
//        nameOne += list[it].directorName?.format("%.2s", list[it].directorName)
        var name = list[it].directorName ?: "Anonymous"
        val nameList = name.split(" ").reversed()
        nameList.indices.forEach { i ->
            if (i > 0) {
                name += "${nameList[i][0]}."
            } else {
                name = nameList[i] + " "
            }
        }
        list[it].directorName = name
        list[it].actors = list[it].actors?.distinct()
    }
    return list
}

fun toStringActor(list: List<Actor>): String {
    var str = "Актеры: "
    (list.indices).forEach {
        str += "${list[it].actorName}, "
    }
    return str
}