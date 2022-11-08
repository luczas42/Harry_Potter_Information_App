package br.com.hp_app.api

import br.com.hp_app.model.Houses
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/Houses")
    suspend fun pegaHouses() : List<Houses>
}