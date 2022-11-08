package br.com.hp_app.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInicializador {

    private const val BASE_URL = "https://wizard-world-api.herokuapp.com"
    val apiService: ApiService

    init {
        val retrofit: Retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
            GsonConverterFactory.create()
        ).build()

        apiService = retrofit.create(ApiService::class.java)
    }
}