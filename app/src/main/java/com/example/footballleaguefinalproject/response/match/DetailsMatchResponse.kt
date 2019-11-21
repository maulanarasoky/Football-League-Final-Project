package com.example.footballleaguefinalproject.response.match

import com.example.footballleaguefinalproject.model.match.DetailsMatch
import com.google.gson.annotations.SerializedName

data class DetailsMatchResponse (
    @SerializedName("events")
    val detailsMatch: List<DetailsMatch>? = null
)