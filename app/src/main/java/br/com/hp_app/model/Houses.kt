package br.com.hp_app.model

import com.google.gson.annotations.SerializedName

data class Houses(
    @SerializedName("id") val id: String = "",
    @SerializedName("name") val name: String = "",
    @SerializedName("houseColours") val houseColours: String = "",
    @SerializedName("founder") val founder: String = "",
    @SerializedName("animal") val animal: String = "",
    @SerializedName("element") val element: String = "",
    @SerializedName("ghost") val ghost: String = "",
    @SerializedName("commonRoom") val commonRoom: String = "",
    @SerializedName("heads") val heads: List<Heads>,
    @SerializedName("traits") val traits: List<Traits>
)

data class Heads(
    @SerializedName("id") val id: String = "",
    @SerializedName("firstName") val firstName: String = "",
    @SerializedName("lastName") val lastName: String = ""
)

data class Traits(
    @SerializedName("id") val id: String = "",
    @SerializedName("name") val name: String = "",
)


