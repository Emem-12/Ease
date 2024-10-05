package com.example.ease.repo

import android.util.Log
import com.example.ease.Response
import com.example.ease.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL

class UserRepository {
    private val url = URL("https://jsonplaceholder.typicode.com/users")

    suspend fun getUsers() : Response {
        Log.d("httpGetRequest", "Requesting...")
        // Open a connection
        val connection = withContext(Dispatchers.IO) {
            url.openConnection()
        } as HttpURLConnection

        try {
            connection.requestMethod = "GET"  // HTTP GET method

            if (connection.responseCode == HttpURLConnection.HTTP_OK) {
                val response = connection.inputStream.bufferedReader().use { it.readText() }

                val gson = Gson()
                val type = object : TypeToken<List<User>>() {}.type
                val listOfUsers = gson.fromJson<List<User>>(response, type)
                Log.d("httpGetRequest", "User count is: ${listOfUsers.size}")

                return Response.Success(data = listOfUsers)
            } else {
                Log.i("httpGetRequest", "Error: ${connection.responseCode}")

                return Response.Failure(message = "Error: ${connection.responseCode}")
            }
        } catch (e: Exception) {
            Log.e("httpGetRequest", "Failed because: ${e.message}")
            return Response.Failure(message = "Error: ${e.message}")
        } finally {
            connection.disconnect()  // Always close the connection
        }
    }
}