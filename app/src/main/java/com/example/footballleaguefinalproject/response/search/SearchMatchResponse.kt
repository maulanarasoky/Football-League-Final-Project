package com.example.footballleaguefinalproject.response.search

import com.example.footballleaguefinalproject.model.match.Match
import com.google.gson.annotations.SerializedName

data class SearchMatchResponse(
    @SerializedName("event")
    val allMatch: List<Match>? = null
)