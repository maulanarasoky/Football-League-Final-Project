package com.example.footballleaguefinalproject.interfaces.team.player

import com.example.footballleaguefinalproject.model.team.player.DetailsPlayers

interface DetailsPlayerView {
    fun showLoading()
    fun hideLoading()
    fun showPlayersDetails(detailsPlayer : List<DetailsPlayers>?)
}