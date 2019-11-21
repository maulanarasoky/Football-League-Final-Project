package com.example.footballleaguefinalproject.model.team.player

import com.google.gson.annotations.SerializedName

data class DetailsPlayers(
    @SerializedName("strNationality")
    var nationality: String? = null,

    @SerializedName("strPlayer")
    var playerName: String? = null,

    @SerializedName("strTeam")
    var playerTeam: String? = null,

    @SerializedName("dateBorn")
    var playerBorn: String? = null,

    @SerializedName("strBirthLocation")
    var birthPlace: String? = null,

    @SerializedName("strDescriptionEN")
    var playerDescription: String? = null,

    @SerializedName("strGender")
    var playerGender: String? = null,

    @SerializedName("strPosition")
    var playerPosition: String? = null,

    @SerializedName("strFacebook")
    var playerFacebook: String? = null,

    @SerializedName("strTwitter")
    var playerTwitter: String? = null,

    @SerializedName("strInstagram")
    var playerInstagram: String? = null,

    @SerializedName("strThumb")
    var playerPic: String? = null
)