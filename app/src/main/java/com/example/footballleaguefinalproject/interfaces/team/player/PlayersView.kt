package com.example.footballleaguefinalproject.interfaces.team.player

import com.example.footballleaguefinalproject.model.team.player.Players

interface PlayersView {
    fun showLoading()
    fun hideLoading()
    fun showPlayers(detailsTeam : List<Players>?)
}