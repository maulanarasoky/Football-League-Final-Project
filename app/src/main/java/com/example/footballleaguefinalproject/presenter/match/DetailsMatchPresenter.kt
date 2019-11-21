package com.example.footballleaguefinalproject.presenter.match

import com.example.footballleaguefinalproject.api.ApiRepository
import com.example.footballleaguefinalproject.api.TheSportDBApi
import com.example.footballleaguefinalproject.coroutines.CoroutineContextProvider
import com.example.footballleaguefinalproject.interfaces.match.DetailsMatchView
import com.example.footballleaguefinalproject.response.match.DetailsMatchResponse
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DetailsMatchPresenter (private val view : DetailsMatchView, private val apiRepository : ApiRepository, private val gson : Gson, private val context: CoroutineContextProvider = CoroutineContextProvider()) {
    fun getDetailsMatch(idMatch : String?) {
        view.showLoading()
        GlobalScope.launch(context.main) {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getDetailsMatch(idMatch)).await(),
                DetailsMatchResponse:: class.java)

            view.hideLoading()
            view.showDetailsMatch(data.detailsMatch)

        }
    }
}