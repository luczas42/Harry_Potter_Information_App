package br.com.hp_app.data.model

import com.google.gson.annotations.SerializedName

data class Ingredients(
    @SerializedName("id") val id: String = "",
    @SerializedName("name") val name: String = "",
)
