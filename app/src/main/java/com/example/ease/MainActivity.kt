package com.example.ease

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container_view, HomeFragment()).commit()*/

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container_view, HomeFragment())
            commit()
        }
    }

}

