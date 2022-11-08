package br.com.hp_app.model

import com.google.gson.annotations.SerializedName

data class Spells(
    @SerializedName("id") val id: String = "",
    @SerializedName("name") val name: String = "",
    @SerializedName("incantation") val incantation: String = "",
    @SerializedName("effect") val effect: String = "",
    @SerializedName("canBeVerbal") val canBeVerbal: Boolean = false,
    @SerializedName("type") val type: String = "",
    @SerializedName("light") val light: String = "",
    @SerializedName("creator") val creator: String = ""
)