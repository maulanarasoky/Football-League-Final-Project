package com.example.footballleaguefinalproject.adapter.team

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.footballleaguefinalproject.R
import com.example.footballleaguefinalproject.activity.team.DetailsTeamActivity
import com.example.footballleaguefinalproject.model.team.Team
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.items_row_league.*
import org.jetbrains.anko.startActivity

class TeamAdapter (private val context : Context, private val items : List<Team>) : RecyclerView.Adapter<TeamAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.items_row_teams, parent, false)
        )

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    class ViewHolder(override val containerView : View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {
        fun bindItem(items : Team){
            tv_name.text = items.teamName

            Glide.with(itemView.context).load(items.teamBadge).apply(RequestOptions.overrideOf(250,250)).into(img_item_photo)

            itemView.setOnClickListener {
                itemView.context.startActivity<DetailsTeamActivity>(
                    DetailsTeamActivity.teamId to items.idTeam,
                    DetailsTeamActivity.teamName to items.teamName
                )
            }
        }
    }
}