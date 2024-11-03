package com.example.practice_5
import retrofit2.http.GET
import retrofit2.http.Path

interface TodosAPI {

    @GET("todos/{id}")

    suspend fun getTodosById(@Path("id") id: Int): Todos

}
