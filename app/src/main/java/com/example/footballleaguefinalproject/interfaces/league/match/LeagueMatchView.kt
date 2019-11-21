package com.example.footballleaguefinalproject.interfaces.league.match

import com.example.footballleaguefinalproject.model.match.Match
import com.example.footballleaguefinalproject.model.team.Team

interface LeagueMatchView {
    fun showLoading()
    fun hideLoading()
    fun showMatchList(dataMatch : List<Match>?, dataTeam: List<Team>)
}