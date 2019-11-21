package com.example.footballleaguefinalproject.adapter.team

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.footballleaguefinalproject.R
import com.example.footballleaguefinalproject.activity.team.player.DetailsPlayer
import com.example.footballleaguefinalproject.model.team.player.Players
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_players.*
import org.jetbrains.anko.startActivity

class ListPlayersAdapter(private val context : Context, private val items : List<Players>) : RecyclerView.Adapter<ListPlayersAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.list_players, parent, false)
        )

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    class ViewHolder(override val containerView : View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {
        fun bindItem(items : Players){
            Glide.with(itemView.context).load(items.playerPic).apply(RequestOptions.overrideOf(500,500)).into(playerPic)
            playerName.text = items.playerName

            itemView.setOnClickListener {
                itemView.context.startActivity<DetailsPlayer>(
                    DetailsPlayer.playerId to items.playerId,
                    DetailsPlayer.playerName to items.playerName
                )
            }
        }
    }
}