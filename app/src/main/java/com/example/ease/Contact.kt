package com.example.ease


import androidx.annotation.DrawableRes
import androidx.annotation.IdRes

data class Contact (var name: String,
                    var userName: String,
                    var website: String,
                    var address: Address,
                    var description: String,
                    var phoneNumber: String,
                    @DrawableRes
                    var imageRes: Int)

data class Address(
    val street: String,
    val lGA: String,
    val country: String
)



