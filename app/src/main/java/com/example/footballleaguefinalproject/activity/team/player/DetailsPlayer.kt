package com.example.footballleaguefinalproject.activity.team.player

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.footballleaguefinalproject.R
import com.example.footballleaguefinalproject.api.ApiRepository
import com.example.footballleaguefinalproject.interfaces.team.player.DetailsPlayerView
import com.example.footballleaguefinalproject.model.team.player.DetailsPlayers
import com.example.footballleaguefinalproject.presenter.team.player.DetailsPlayerPresenter
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_details_player.*
import org.jetbrains.anko.find

class DetailsPlayer : AppCompatActivity(), DetailsPlayerView {

    private lateinit var players: DetailsPlayers
    private lateinit var progressBar: ProgressBar
    private lateinit var presenter: DetailsPlayerPresenter

    private val playersArray: MutableList<DetailsPlayers> = mutableListOf()

    companion object {
        const val playerId = "playerId"
        const val playerName = "PlayerName"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_player)

        val id = intent.getStringExtra(playerId)
        val name = intent.getStringExtra(playerName)

        val collapsingToolbar: CollapsingToolbarLayout = find(R.id.collapsingToolbar)
        collapsingToolbar.setExpandedTitleColor(resources.getColor(android.R.color.transparent))

        val toolbar: Toolbar = find(R.id.toolBar)
        setSupportActionBar(toolbar)

        supportActionBar?.title = name

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        progressBar = find(R.id.progressBar)

        val request = ApiRepository()
        val gson = Gson()

        presenter = DetailsPlayerPresenter(
            this,
            request,
            gson
        )

        presenter.getDetailsPlayer(id)
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun showPlayersDetails(detailsPlayer: List<DetailsPlayers>?) {
        this.playersArray.clear()
        if(detailsPlayer != null) {
            this.playersArray.addAll(detailsPlayer)

            players = DetailsPlayers(
                playersArray[0].nationality,
                playersArray[0].playerName,
                playersArray[0].playerTeam,
                playersArray[0].playerBorn,
                playersArray[0].birthPlace,
                playersArray[0].playerDescription,
                playersArray[0].playerGender,
                playersArray[0].playerPosition,
                playersArray[0].playerFacebook,
                playersArray[0].playerTwitter,
                playersArray[0].playerInstagram,
                playersArray[0].playerPic
            )

            teamName.text = players.playerTeam
            gender.text = players.playerGender
            birthDate.text = players.playerBorn
            birthPlace.text = players.birthPlace
            positionName.text = players.playerPosition

            descriptionPlayer.text = players.playerDescription

            Glide.with(this).load(players.playerPic).apply(RequestOptions.overrideOf(500,500)).into(imgHeader)
        }
    }
}
