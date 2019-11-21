package com.example.footballleaguefinalproject.response.team

import com.example.footballleaguefinalproject.model.team.Team
import com.google.gson.annotations.SerializedName

data class TeamResponse(
    @SerializedName("teams")
    val teams: List<Team>
)