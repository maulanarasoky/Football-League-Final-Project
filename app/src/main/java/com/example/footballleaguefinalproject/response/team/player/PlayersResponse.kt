package com.example.footballleaguefinalproject.response.team.player

import com.example.footballleaguefinalproject.model.team.player.Players
import com.google.gson.annotations.SerializedName

data class PlayersResponse(
    @SerializedName("player")
    var player: List<Players>? = null
)