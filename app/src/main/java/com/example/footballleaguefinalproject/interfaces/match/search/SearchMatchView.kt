package com.example.footballleaguefinalproject.interfaces.match.search

import com.example.footballleaguefinalproject.model.match.Match
import com.example.footballleaguefinalproject.model.team.Team

interface SearchMatchView {
    fun showLoading()
    fun hideLoading()
    fun showMatchList(dataMatch : List<Match>?, dataTeam: List<Team>)
}