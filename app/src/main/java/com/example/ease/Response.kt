package com.example.ease

sealed class Response {
    data class Success(var data: Any) : Response()
    data class Failure(var message: String) : Response()
}