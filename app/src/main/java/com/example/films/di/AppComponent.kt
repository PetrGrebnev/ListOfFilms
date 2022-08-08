package com.example.films.di

import com.example.films.screen.listfrgament.ListFilmsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, AppModule::class])
interface AppComponent {

    fun inject(fragment: ListFilmsFragment)
}