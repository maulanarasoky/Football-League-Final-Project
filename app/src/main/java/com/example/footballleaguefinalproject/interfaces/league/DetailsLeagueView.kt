package com.example.footballleaguefinalproject.interfaces.league

import com.example.footballleaguefinalproject.model.team.Team

interface DetailsLeagueView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data : List<Team>)
}