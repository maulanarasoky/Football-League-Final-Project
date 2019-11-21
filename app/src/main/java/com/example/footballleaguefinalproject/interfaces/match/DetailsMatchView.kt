package com.example.footballleaguefinalproject.interfaces.match

import com.example.footballleaguefinalproject.model.match.DetailsMatch

interface DetailsMatchView {
    fun showLoading()
    fun hideLoading()
    fun showDetailsMatch(detailsMatch : List<DetailsMatch>?)
}