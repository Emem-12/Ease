package com.example.ease

import com.google.gson.annotations.SerializedName

/*data class Address(
    val street: String,
    val lGA: String,
    val country: String
)*/

data class Address(
    val city: String,
//    val geo: Geo,
    val street: String,
    @SerializedName("suite")
    val suite: String,
    val zipcode: String
)