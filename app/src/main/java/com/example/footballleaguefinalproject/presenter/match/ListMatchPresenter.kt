package com.example.footballleaguefinalproject.presenter.match

import com.example.footballleaguefinalproject.api.ApiRepository
import com.example.footballleaguefinalproject.api.TheSportDBApi
import com.example.footballleaguefinalproject.coroutines.CoroutineContextProvider
import com.example.footballleaguefinalproject.interfaces.league.match.LeagueMatchView
import com.example.footballleaguefinalproject.response.match.ListMatchResponse
import com.example.footballleaguefinalproject.response.team.TeamResponse
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListMatchPresenter(private val view : LeagueMatchView, private val apiRepository : ApiRepository, private val gson : Gson, private val context: CoroutineContextProvider = CoroutineContextProvider()) {
    fun getLastMatchList(idLeague : String?, nameLeague: String?) {
        view.showLoading()
        GlobalScope.launch(context.main) {
            val dataMatch = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getLastMatch(idLeague)).await(),
                ListMatchResponse:: class.java)

            val dataTeam = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getTeams(nameLeague)).await(),
                TeamResponse:: class.java)


            view.hideLoading()
            view.showMatchList(dataMatch.match, dataTeam.teams)

        }
    }

    fun getNextMatchList(idLeague : String?, nameLeague: String?) {
        view.showLoading()
        GlobalScope.launch(context.main) {
            val dataMatch = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getNextMatch(idLeague)).await(),
                ListMatchResponse:: class.java)

            val dataTeam = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getTeams(nameLeague)).await(),
                TeamResponse:: class.java)


            view.hideLoading()
            view.showMatchList(dataMatch.match, dataTeam.teams)

        }
    }
}