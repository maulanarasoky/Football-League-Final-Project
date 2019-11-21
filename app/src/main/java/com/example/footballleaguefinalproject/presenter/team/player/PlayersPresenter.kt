package com.example.footballleaguefinalproject.presenter.team.player

import com.example.footballleaguefinalproject.api.ApiRepository
import com.example.footballleaguefinalproject.api.TheSportDBApi
import com.example.footballleaguefinalproject.coroutines.CoroutineContextProvider
import com.example.footballleaguefinalproject.interfaces.team.player.PlayersView
import com.example.footballleaguefinalproject.response.team.player.PlayersResponse
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PlayersPresenter(private val view : PlayersView, private val apiRepository : ApiRepository, private val gson : Gson, private val context: CoroutineContextProvider = CoroutineContextProvider()) {
    fun getDetailsTeam(idTeam: String?) {
        view.showLoading()
        GlobalScope.launch(context.main) {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.listPlayers(idTeam)).await(),
                PlayersResponse::class.java)

            view.hideLoading()
            view.showPlayers(data.player)

        }
    }
}