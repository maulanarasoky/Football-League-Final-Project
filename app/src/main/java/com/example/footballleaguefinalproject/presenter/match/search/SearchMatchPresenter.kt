package com.example.footballleaguefinalproject.presenter.match.search

import com.example.footballleaguefinalproject.api.ApiRepository
import com.example.footballleaguefinalproject.api.TheSportDBApi
import com.example.footballleaguefinalproject.coroutines.CoroutineContextProvider
import com.example.footballleaguefinalproject.interfaces.match.search.SearchMatchView
import com.example.footballleaguefinalproject.response.search.SearchMatchResponse
import com.example.footballleaguefinalproject.response.team.TeamResponse
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SearchMatchPresenter(private val view : SearchMatchView, private val apiRepository : ApiRepository, private val gson : Gson, private val context: CoroutineContextProvider = CoroutineContextProvider()) {
    fun searchMatch(matchName : String?, nameLeague: String?){
        view.showLoading()
        GlobalScope.launch(context.main) {
            val dataMatch = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.searchMatch(matchName)).await(),
                SearchMatchResponse:: class.java)

            val dataTeam = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getTeams(nameLeague)).await(),
                TeamResponse:: class.java)


            view.hideLoading()
            view.showMatchList(dataMatch.allMatch, dataTeam.teams)

        }
    }
}