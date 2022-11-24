package br.com.hp_app.data.model

import com.google.gson.annotations.SerializedName

data class Spells(
    @SerializedName("id") val id: String = "",
    @SerializedName("name") val name: String = "",
    @SerializedName("incantation") val _incantation: String?,
    @SerializedName("effect") val effect: String = "",
    @SerializedName("canBeVerbal") val canBeVerbal: Boolean = false,
    @SerializedName("type") val type: String = "",
    @SerializedName("light") val light: String = "",
    @SerializedName("creator") val _creator: String?
){
    val incantation get() = _incantation ?: "Unknown"
    val creator get() = _creator ?: "Unknown"
}