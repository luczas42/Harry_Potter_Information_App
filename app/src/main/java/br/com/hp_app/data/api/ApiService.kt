package br.com.hp_app.data.api

import br.com.hp_app.data.model.*
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/Houses")

    suspend fun getHouses(): List<Houses>

    @GET("/Houses/{id}")
    suspend fun getHousesById(
        @Path("id") idHouse: String
    ): Houses

    @GET("/Elixirs")
    suspend fun getElixirs(): List<Elixirs>

    @GET("/Elixirs/{id}")
    suspend fun getElixirsById(
        @Path("id") idElixir: String
    ): Elixirs

    @GET("/Ingredients")
    suspend fun getIngredients(): List<Ingredients>

    @GET("/Ingredients/{id}")
    suspend fun getIngredientById(
        @Path("id") ingredientId: String
    ): Ingredients

    @GET("/Wizards")
    suspend fun getWizards(): List<Wizards>

    @GET("/Wizards/{id}")
    suspend fun getWizardById(
        @Path("id") wizardId: String
    ): Wizards

    @GET("/Spells")
    suspend fun getSpells(): List<Spells>

    @GET("/Spells/{id}")
    suspend fun getSpellsById(
        @Path("id") idSpell: String
    ): Spells


}