package com.example.freetogame.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.freetogame.data.Game
import com.example.freetogame.databinding.ItemGameBinding

class GameAdapter : RecyclerView.Adapter<GameAdapter.GameViewHolder>() {

    var gamesList = listOf<Game>()

    class GameViewHolder(private val binding: ItemGameBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(game: Game) {
            binding.titleTextview.text = game.title
            binding.developerTextview.text = game.developer

            Glide.with(binding.thumbnailImageview.context).load(game.thumbnail)
                .into(binding.thumbnailImageview)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        return GameViewHolder(
            ItemGameBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = gamesList.size

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.bind(gamesList[position])
    }


    fun updateList(newGamesList: List<Game>){
        gamesList = newGamesList
        notifyDataSetChanged()
    }
}