package br.com.hp_app.api

import br.com.hp_app.model.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("/Houses")

    suspend fun pegaHouses(): List<Houses>

    @GET("/Houses/{id}")
    suspend fun pegaHousePorId(
        @Path("id") idHouse: String
    ): Houses

    @GET("/Elixirs")
    suspend fun pegaElixirs(): List<Elixirs>

    @GET("/Ingredients")
    suspend fun pegaIngredients(): List<Ingredients>

    @GET("/Wizards")
    suspend fun pegaWizards(): List<Wizards>

    @GET("/Spells")
    suspend fun pegaSpells(): List<Spells>
}