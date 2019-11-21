package com.example.footballleaguefinalproject.response.team.player

import com.example.footballleaguefinalproject.model.team.player.DetailsPlayers
import com.google.gson.annotations.SerializedName

data class DetailsPlayerResponse(
    @SerializedName("players")
    var detailsPlayer: List<DetailsPlayers>? = null
)