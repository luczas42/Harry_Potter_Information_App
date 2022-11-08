package br.com.hp_app.model

import com.google.gson.annotations.SerializedName

//    "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
//    "name": "string",
//    "effect": "string",
//    "sideEffects": "string",
//    "characteristics": "string",
//    "time": "string",
//    "difficulty": "Unknown",
//    "ingredients": [
//    {
//        "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
//        "name": "string"
//    }
//    ],
//    "inventors": [
//    {
//        "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
//        "firstName": "string",
//        "lastName": "string"
//    }
//    ],
//    "manufacturer": "string"

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
