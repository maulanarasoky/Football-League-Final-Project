package com.example.footballleaguefinalproject.response.team

import com.example.footballleaguefinalproject.model.team.DetailsTeam
import com.google.gson.annotations.SerializedName

data class DetailsTeamResponse(
    @SerializedName("teams")
    val teams: List<DetailsTeam>? = null
)