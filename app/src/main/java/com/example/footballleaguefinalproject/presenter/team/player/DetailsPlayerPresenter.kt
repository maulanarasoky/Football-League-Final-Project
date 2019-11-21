package com.example.footballleaguefinalproject.presenter.team.player

import com.example.footballleaguefinalproject.api.ApiRepository
import com.example.footballleaguefinalproject.api.TheSportDBApi
import com.example.footballleaguefinalproject.coroutines.CoroutineContextProvider
import com.example.footballleaguefinalproject.interfaces.team.player.DetailsPlayerView
import com.example.footballleaguefinalproject.response.team.player.DetailsPlayerResponse
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DetailsPlayerPresenter(private val view : DetailsPlayerView, private val apiRepository : ApiRepository, private val gson : Gson, private val context: CoroutineContextProvider = CoroutineContextProvider()) {
    fun getDetailsPlayer(idPlayer: String?) {
        view.showLoading()
        GlobalScope.launch(context.main) {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.detailsPlayer(idPlayer)).await(),
                DetailsPlayerResponse::class.java)

            view.hideLoading()
            view.showPlayersDetails(data.detailsPlayer)

        }
    }
}