package br.com.hp_app.data.api

import br.com.hp_app.data.model.Ingredients
import br.com.hp_app.data.model.Spells
import br.com.hp_app.data.model.Wizards

class Repository(private val retrofitCon: RetrofitInicializador) {

    suspend fun getHouses() =
        retrofitCon.apiService.getHouses()

    suspend fun getHousesById(idHouse: String) =
        retrofitCon.apiService.getHousesById(idHouse)

    suspend fun getElixirs() =
        retrofitCon.apiService.getElixirs()

    suspend fun getElixirsById(idElixir: String) =
        retrofitCon.apiService.getElixirsById(idElixir)

    suspend fun getIngredients() =
        retrofitCon.apiService.getIngredients()

    suspend fun getIngredientById(ingredientId: String): Ingredients =
        retrofitCon.apiService.getIngredientById(ingredientId)

    suspend fun getWizards() =
        retrofitCon.apiService.getWizards()

    suspend fun getWizardById(wizardId: String): Wizards =
        retrofitCon.apiService.getWizardById(wizardId)

    suspend fun getSpells() =
        retrofitCon.apiService.getSpells()

    suspend fun getSpellsById(idSpell: String): Spells =
        retrofitCon.apiService.getSpellsById(idSpell)


}
