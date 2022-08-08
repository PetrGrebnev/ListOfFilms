package com.example.films.di

import android.util.Log
import com.example.films.network.GetJsonFilm
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val BASE_URL =
    "https://raw.githubusercontent.com/constanta-android-dev/intership-wellcome-task/main/"

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providerJson(): GetJsonFilm {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(getOkHttpClient())
            .build()
        return retrofit.create(GetJsonFilm::class.java)
    }

    private fun getOkHttpClient() =
        OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor { message ->
                    Log.d("OK HTTP", message)
                }.apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()
}