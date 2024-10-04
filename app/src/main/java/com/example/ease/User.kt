package com.example.ease


import androidx.annotation.DrawableRes

data class User (var name: String,
                    var userName: String,
                    var website: String,
                    var address: Address,
                    var description: String,
                    var phoneNumber: String,
                    @DrawableRes
                    var imageRes: Int)




