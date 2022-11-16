package br.com.hp_app.data.api

import br.com.hp_app.data.model.*
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/Houses")

    suspend fun pegaHouses(): List<Houses>

    @GET("/Houses/{id}")
    suspend fun pegaHousePorId(
        @Path("id") idHouse: String
    ): Houses

    @GET("/Elixirs")
    suspend fun pegaElixirs(): List<Elixirs>

    @GET("/Elixirs/{id}")
    suspend fun pegaElixirsPorId(
        @Path("id") idElixir: String
    ):Elixirs

    @GET("/Ingredients")
    suspend fun pegaIngredients(): List<Ingredients>

    @GET("/Wizards")
    suspend fun pegaWizards(): List<Wizards>

    @GET("/Spells")
    suspend fun pegaSpells(): List<Spells>

}