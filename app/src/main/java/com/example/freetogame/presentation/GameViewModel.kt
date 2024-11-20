package com.example.freetogame.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.example.freetogame.data.Game
import com.example.freetogame.data.GameRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class GameViewModel : ViewModel(){
    private val repository = GameRepository()
    val gameFlow = MutableStateFlow<List<Game>>(emptyList())

    fun getGames() = viewModelScope.launch {
        val gamesList = repository.getGamesList()
        gameFlow.emit(gamesList)
    }
}