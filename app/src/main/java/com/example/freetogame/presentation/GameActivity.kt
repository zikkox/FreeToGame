package com.example.freetogame.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.freetogame.data.Game
import com.example.freetogame.data.GameRepository
import com.example.freetogame.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class GameActivity : AppCompatActivity() {

    private val viewModel by viewModels<GameViewModel>()

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val gameAdapter = GameAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViews()
        viewModel.getGames()
        setCollectors()
    }

    private fun initViews(){
        binding.recyclerview.adapter = gameAdapter
    }

    private fun setCollectors() = lifecycleScope.launch {
        viewModel.gameFlow.collect() { gamesList ->
            gameAdapter.updateList(gamesList)
        }
    }
}