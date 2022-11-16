package br.com.hp_app.data.model

import com.google.gson.annotations.SerializedName

data class Wizards(
    @SerializedName("id") val id: String = "",
    @SerializedName("firstName") val firstName: String = "",
    @SerializedName("lastName") val lastName: String = "",
    @SerializedName("elixirs") val elixirs: List<Elixirs>
)
