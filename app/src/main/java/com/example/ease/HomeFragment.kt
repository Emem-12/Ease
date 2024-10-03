package com.example.ease

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ease.databinding.FragmentHomeBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL



class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var contactAdapter: ContactAdapter
    private lateinit var contact: MutableList<Contact>



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    val gson = Gson()
    val jsonString =gson.toJson(contact)
    String jsonData{
        "name":"Christophy Barth",
       "userName":"@Christophy",
        "website":"www.mywebsite.com",
        "address":{
            "street":"Lives in Grace Bill street",
            "L.G.A":"Eket",
            "country":"Nigeria"
        },
        "description":"works at Fhenix Africa",
        "phone":"+234 7622868857"
    },
    {
        "name": "Aisha Bello",
        "userName": "@AishaB",
        "website": "www.aishabello.com",
        "address": {
        "street": "78 Sunset Boulevard",
        "L.G.A": "Ikeja",
        "country": "Nigeria"
    },
        "description": "Graphic designer and art lover"
    },
    {
        "name": "Michael Johnson",
        "userName": "@MikeJ",
        "website": "www.michaeljohnson.com",
        "address": {
        "street": "45 Oak Street",
        "L.G.A": "Lekki",
        "country": "Nigeria"
    },
        "description": "Software engineer and tech enthusiast"
    },


    /*

        private fun httpGetRequest() {
            // Specify the URL
            val url = URL("https://jsonplaceholder.typicode.com/users")

            CoroutineScope(Dispatchers.IO).launch {
                // Open a connection
                val connection = url.openConnection() as HttpURLConnection

                try {
                    connection.requestMethod = "GET"  // HTTP GET method

                    // Check the response code
                    if (connection.responseCode == HttpURLConnection.HTTP_OK) {
                        val response = connection.inputStream.bufferedReader().use { it.readText() }

                        val gson = Gson()
                        val type = object : TypeToken<List<User>>() {}.type
                        val listOfUsers = gson.fromJson<List<User>>(response, type)
                        println("Response: ${listOfUsers.random()}")

                        withContext(Dispatchers.Main){
                            binding.name.text = listOfUsers.random().name
                        }
                    } else {
                        println("Error: ${connection.responseCode}")
                    }
                } catch (e: Exception) {
                    println("Failed because: ${e.message}")
                } finally {
                    connection.disconnect()  // Always close the connection
                }

            }

        }
    */


}