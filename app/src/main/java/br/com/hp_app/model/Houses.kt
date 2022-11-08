package br.com.hp_app.model

import com.google.gson.annotations.SerializedName

data class Houses(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("houseColours") val houseColours: String
)
