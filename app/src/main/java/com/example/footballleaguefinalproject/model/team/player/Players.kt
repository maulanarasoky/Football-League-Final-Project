package com.example.footballleaguefinalproject.model.team.player

import com.google.gson.annotations.SerializedName

data class Players(
    @SerializedName("idPlayer")
    var playerId: String? = null,

    @SerializedName("strPlayer")
    var playerName: String? = null,

    @SerializedName("strCutout")
    var playerPic: String? = null
)