package com.example.catsapp

import com.google.gson.annotations.SerializedName

data class Cat(
    val length: String,
    val origin: String,
    @SerializedName("image_link") val imageLink: String,
    @SerializedName("family_friendly") val familyFriendly: Int,
    val shedding: Int,
    @SerializedName("general_health") val generalHealth: Int,
    val playfulness: Int,
    val meowing: Int,
    @SerializedName("children_friendly") val childrenFriendly: Int,
    @SerializedName("stranger_friendly") val strangerFriendly: Int,
    val grooming: Int,
    val intelligence: Int,
    @SerializedName("other_pets_friendly") val otherPetsFriendly: Int,
    @SerializedName("min_weight") val minWeight: Int,
    @SerializedName("max_weight") val maxWeight: Int,
    @SerializedName("min_life_expectancy") val minLifeExpectancy: Int,
    @SerializedName("max_life_expectancy") val maxLifeExpectancy: Int,
    val name: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Cat) return false

        if (length != other.length) return false
        if (origin != other.origin) return false
        if (imageLink != other.imageLink) return false
        if (familyFriendly != other.familyFriendly) return false
        if (shedding != other.shedding) return false
        if (generalHealth != other.generalHealth) return false
        if (playfulness != other.playfulness) return false
        if (meowing != other.meowing) return false
        if (childrenFriendly != other.childrenFriendly) return false
        if (strangerFriendly != other.strangerFriendly) return false
        if (grooming != other.grooming) return false
        if (intelligence != other.intelligence) return false
        if (otherPetsFriendly != other.otherPetsFriendly) return false
        if (minWeight != other.minWeight) return false
        if (maxWeight != other.maxWeight) return false
        if (minLifeExpectancy != other.minLifeExpectancy) return false
        if (maxLifeExpectancy != other.maxLifeExpectancy) return false
        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        var result = length.hashCode()
        result = 31 * result + origin.hashCode()
        result = 31 * result + imageLink.hashCode()
        result = 31 * result + familyFriendly
        result = 31 * result + shedding
        result = 31 * result + generalHealth
        result = 31 * result + playfulness
        result = 31 * result + meowing
        result = 31 * result + childrenFriendly
        result = 31 * result + strangerFriendly
        result = 31 * result + grooming
        result = 31 * result + intelligence
        result = 31 * result + otherPetsFriendly
        result = 31 * result + minWeight
        result = 31 * result + maxWeight
        result = 31 * result + minLifeExpectancy
        result = 31 * result + maxLifeExpectancy
        result = 31 * result + name.hashCode()
        return result
    }
}