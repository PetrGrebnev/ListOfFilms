package com.example.films.screen.listfrgament

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.films.models.Film
import com.example.films.repository.Repository
import com.example.films.utils.CheckInternetConnection
import com.example.films.utils.ResultState
import com.example.films.utils.dateSort
import com.example.films.utils.fullNameDirector
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListFilmsViewModel(context: Context, repository: Repository) : ViewModel() {

    var films = MutableLiveData<ResultState<List<Film>>>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            while (!CheckInternetConnection.isInternetAvailable(context)) {
                films.postValue(ResultState.Loading())
            }
            getFilm(repository)
        }
    }

    private suspend fun getFilm(repository: Repository) {
        films.postValue(ResultState.Loading())
        val result = repository.getFilms()
        if (result.isSuccessful) {
            val dateSort = dateSort(result.body()!!.items as MutableList<Film>)
            val fullNameDirector = fullNameDirector(dateSort as MutableList<Film>)
            films.postValue(ResultState.Success(fullNameDirector))
        } else {
            films.postValue(ResultState.Error(RuntimeException("Response body null")))
        }
    }
}