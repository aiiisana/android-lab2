package com.example.catsapp

import com.google.gson.annotations.SerializedName

data class Cat(
    val length: String,
    val origin: String,
    @SerializedName("image_link") val imageLink: String,
    @SerializedName("family_friendly") val familyFriendly: Int,
    val playfulness: Int,
    val intelligence: Int,
    val name: String
//    val shedding: Int,
//    @SerializedName("general_health") val generalHealth: Int,
//    val meowing: Int,
//    @SerializedName("children_friendly") val childrenFriendly: Int,
//    @SerializedName("stranger_friendly") val strangerFriendly: Int,
//    val grooming: Int,
//    @SerializedName("other_pets_friendly") val otherPetsFriendly: Int,
//    @SerializedName("min_weight") val minWeight: Int,
//    @SerializedName("max_weight") val maxWeight: Int,
//    @SerializedName("min_life_expectancy") val minLifeExpectancy: Int,
//    @SerializedName("max_life_expectancy") val maxLifeExpectancy: Int,
)