package br.com.hp_app.data.model

import com.google.gson.annotations.SerializedName

data class Elixirs(
    @SerializedName("id") val id: String = "",
    @SerializedName("name") val name: String = "",
    @SerializedName("effect") val _effect: String?,
    @SerializedName("sideEffects") val _sideEffects: String?,
    @SerializedName("characteristics") val _characteristics: String?,
    @SerializedName("time") val _time: String?,
    @SerializedName("difficulty") val difficulty: String = "",
    @SerializedName("ingredients") val ingredients: List<Ingredients>,
    @SerializedName("inventors") val inventors: List<Inventors>,
    @SerializedName("manufacturer") val _manufacturer: String?
) {
    val characteristics get() = _characteristics ?: "Unknown"
    val effect get() = _effect ?: "Unknown"
    val sideEffects get() = _sideEffects ?: "Unknown"
    val time get() = _time ?: "Unknown"
    val manufacturer get() = _manufacturer ?: "Unknown"
}

data class Inventors(
    @SerializedName("id") val id: String = "",
    @SerializedName("firstName") val firstName: String,
    @SerializedName("lastName") val lastName: String = "",
)
