package com.example.ease

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var user: MutableList<User>
    lateinit var userAdapter: UserAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        user = mutableListOf()

        val user1 =
                User(
                    name = "Alice Smith",
                    userName = "alice.smith",
                    website = "www.alicesmith.com",
                    address = Address(
                        street = "123 Maple St",
                        lGA = "Springfield",
                        country = "U.S"

                    ),
                    description = "Avid traveler and blogger.",
                    phoneNumber = "555-0123",
                    imageRes = R.drawable.icon_phone_call
                )
        val user2 =
            User(
                name = "Ella Smith",
                userName = "alice.smith",
                website = "www.alicesmith.com",
                address = Address(
                    street = "123 Maple St",
                    lGA = "Springfield",
                    country = "U.S"

                ),
                description = "Avid traveler and blogger.",
                phoneNumber = "555-0123",
                imageRes = R.drawable.icon_phone_call
            )
     val user3=
         User(
            name = "Melody Smith",
            userName = "alice.smith",
            website = "www.alicesmith.com",
            address = Address(
                street = "123 Maple St",
                lGA = "Springfield",
                country = "U.S"

            ),
            description = "Avid traveler and blogger.",
            phoneNumber = "555-0123",
            imageRes = R.drawable.icon_phone_call
        )



        user.add(user1)
        user.add(user2)
        user.add(user3)




        Log.d("MainActivity", "onCreate: ${user.size}")
        var recyclerView = findViewById<RecyclerView>(R.id.Recyclerview)
        var user = user

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = UserAdapter(user)

    }

}

