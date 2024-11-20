package com.example.freetogame.data

import retrofit2.http.GET

interface GameService {
    @GET("games")
    suspend fun getGames(): retrofit2.Response<List<Game>>
}