package com.example.ease

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.ease.databinding.FragmentHomeBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var userAdapter: UserAdapter
    private lateinit var user: MutableList<User>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

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
                    println("Response: ${listOfUsers.size}")

                    withContext(Dispatchers.Main) {
                        user.addAll(listOfUsers)
                        //  binding.name.text = listOfUsers.random().name
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        httpGetRequest()

    }
}


