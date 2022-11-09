package br.com.hp_app.model

import com.google.gson.annotations.SerializedName

data class Elixirs(
    @SerializedName("id") val id: String = "",
    @SerializedName("name") val name: String = "",
    @SerializedName("effect") val effect: String = "",
    @SerializedName("sideEffects") val sideEffects: String = "",
    @SerializedName("characteristics") val characteristics: String = "",
    @SerializedName("time") val time: String = "",
    @SerializedName("difficulty") val difficulty: String = "",
    @SerializedName("ingredients") val ingredients: List<Ingredients>,
    @SerializedName("inventors") val inventors: List<Inventors>,
    @SerializedName("manufacturer") val manufacturer: String = ""
)

data class Inventors(
    @SerializedName("id") val id: String = "",
    @SerializedName("firstName") val firstName: String = "",
    @SerializedName("lastName") val lastName: String = "",
)
