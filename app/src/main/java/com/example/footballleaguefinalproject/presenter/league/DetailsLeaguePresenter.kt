package com.example.footballleaguefinalproject.presenter.league

import com.example.footballleaguefinalproject.api.ApiRepository
import com.example.footballleaguefinalproject.api.TheSportDBApi
import com.example.footballleaguefinalproject.coroutines.CoroutineContextProvider
import com.example.footballleaguefinalproject.interfaces.league.DetailsLeagueView
import com.example.footballleaguefinalproject.response.team.TeamResponse
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class DetailsLeaguePresenter(private val view : DetailsLeagueView, private val apiRepository : ApiRepository, private val gson : Gson, private val context: CoroutineContextProvider = CoroutineContextProvider()){
    fun getTeamList(league : String?) {
        view.showLoading()
        GlobalScope.launch(context.main) {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getTeams(league)).await(),
                TeamResponse:: class.java)


            view.hideLoading()
            view.showTeamList(data.teams)

        }
    }
}