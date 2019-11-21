package com.example.footballleaguefinalproject.model.team

import com.google.gson.annotations.SerializedName

data class DetailsTeam(

    @SerializedName("strLeague")
    var league: String? = null,

    @SerializedName("strStadium")
    var stadium: String? = null,

    @SerializedName("strWebsite")
    var website: String? = null,

    @SerializedName("strFacebook")
    var facebook: String? = null,

    @SerializedName("strTwitter")
    var twitter: String? = null,

    @SerializedName("strInstagram")
    var instagram: String? = null,

    @SerializedName("strDescriptionEN")
    var description: String? = null,

    @SerializedName("strTeamBadge")
    var teamBadge: String? = null
)