package com.example.footballleaguefinalproject.presenter.team

import com.example.footballleaguefinalproject.api.ApiRepository
import com.example.footballleaguefinalproject.api.TheSportDBApi
import com.example.footballleaguefinalproject.coroutines.CoroutineContextProvider
import com.example.footballleaguefinalproject.interfaces.team.DetailsTeamView
import com.example.footballleaguefinalproject.response.team.DetailsTeamResponse
import com.example.footballleaguefinalproject.response.team.player.PlayersResponse
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DetailsTeamPresenter(private val view : DetailsTeamView, private val apiRepository : ApiRepository, private val gson : Gson, private val context: CoroutineContextProvider = CoroutineContextProvider()) {
    fun getDetailsTeam(idTeam: String?) {
        view.showLoading()
        GlobalScope.launch(context.main) {
            val detailsTeam = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getDetailsTeam(idTeam)).await(),
                DetailsTeamResponse::class.java)

            val listPlayers = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.listPlayers(idTeam)).await(),
                PlayersResponse::class.java)

            view.hideLoading()
            view.showDetailsTeam(detailsTeam.teams, listPlayers.player)

        }
    }
}