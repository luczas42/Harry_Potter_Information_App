package br.com.hp_app.api

class Repository(private val retrofitCon: RetrofitInicializador) {

    suspend fun pegaHouses() = retrofitCon.apiService.pegaHouses()

    suspend fun pegaElixirs() = retrofitCon.apiService.pegaElixirs()

    suspend fun pegaIngredients() = retrofitCon.apiService.pegaIngredients()

    suspend fun pegaWizards() = retrofitCon.apiService.pegaWizards()

    suspend fun pegaSpells() = retrofitCon.apiService.pegaSpells()
}
