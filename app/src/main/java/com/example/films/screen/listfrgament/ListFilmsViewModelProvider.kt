package com.example.films.screen.listfrgament

import android.content.Context
import com.example.films.screen.base.BaseViewModelFactory
import com.example.films.repository.Repository
import javax.inject.Inject

class ListFilmsViewModelProvider @Inject constructor(
    private val context: Context,
    private val repository: Repository,
) : BaseViewModelFactory<ListFilmsViewModel>(ListFilmsViewModel::class.java) {

    override fun createViewModel(): ListFilmsViewModel {
        return ListFilmsViewModel(context, repository)
    }

}