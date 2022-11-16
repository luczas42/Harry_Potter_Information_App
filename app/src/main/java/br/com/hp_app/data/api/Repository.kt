package br.com.hp_app.data.api

class Repository(private val retrofitCon: RetrofitInicializador) {

    suspend fun pegaHouses() =
        retrofitCon.apiService.pegaHouses()

    suspend fun pegaHousesPorId(idHouse: String) =
        retrofitCon.apiService.pegaHousePorId(idHouse)

    suspend fun pegaElixirs() =
        retrofitCon.apiService.pegaElixirs()

    suspend fun pegaElixirsPorId(idElixir: String) =
        retrofitCon.apiService.pegaElixirsPorId(idElixir)

    suspend fun pegaIngredients() =
        retrofitCon.apiService.pegaIngredients()

    suspend fun pegaWizards() =
        retrofitCon.apiService.pegaWizards()

    suspend fun pegaSpells() =
        retrofitCon.apiService.pegaSpells()

}
