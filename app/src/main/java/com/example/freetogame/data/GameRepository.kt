package com.example.freetogame.data

import com.example.freetogame.presentation.GameAdapter

class GameRepository {

    private val gameAdapter = GameAdapter()

    suspend fun getGamesList(): List<Game> {
        val retrofitInstance = RetrofitInstance()
        val createApi = retrofitInstance.createRetrofit().create(GameService::class.java)

        return createApi.getGames().body() ?: emptyList()
    }
}