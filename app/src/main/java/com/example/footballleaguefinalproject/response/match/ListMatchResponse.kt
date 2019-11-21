package com.example.footballleaguefinalproject.response.match

import com.example.footballleaguefinalproject.model.match.Match
import com.google.gson.annotations.SerializedName

data class ListMatchResponse(
    @SerializedName("events")
    val match: List<Match>
)