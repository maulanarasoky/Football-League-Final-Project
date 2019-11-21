package com.example.footballleaguefinalproject.interfaces.team

import com.example.footballleaguefinalproject.model.team.DetailsTeam
import com.example.footballleaguefinalproject.model.team.player.Players

interface DetailsTeamView {
    fun showLoading()
    fun hideLoading()
    fun showDetailsTeam(detailsTeam : List<DetailsTeam>?, listPlayers: List<Players>?)
}