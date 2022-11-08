package br.com.hp_app.api

import br.com.hp_app.model.*
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/Houses")
    suspend fun pegaHouses() : List<Houses>

    @GET("/Elixirs")
    suspend fun pegaElixirs() : List<Elixirs>

    @GET("/Ingredients")
    suspend fun pegaIngredients() : List<Ingredients>

    @GET("/Wizards")
    suspend fun pegaWizards() : List<Wizards>

    @GET("/Spells")
    suspend fun pegaSpells() : List<Spells>
}