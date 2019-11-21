package com.example.footballleaguefinalproject.api

import com.example.footballleaguefinalproject.BuildConfig

object TheSportDBApi {
    fun getTeams(league : String?):String{
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/search_all_teams.php?l=" + league
    }

    fun getLastMatch(idLeague : String?):String{
        return "${BuildConfig.BASE_URL}api/v1/json/${BuildConfig.TSDB_API_KEY}/eventspastleague.php?id=${idLeague}"
    }

    fun getNextMatch(idLeague : String?):String{
        return "${BuildConfig.BASE_URL}api/v1/json/${BuildConfig.TSDB_API_KEY}/eventsnextleague.php?id=${idLeague}"
    }

    fun getDetailsMatch(idMatch : String?) : String{
        return "${BuildConfig.BASE_URL}api/v1/json/${BuildConfig.TSDB_API_KEY}/lookupevent.php?id=${idMatch}"
    }

    fun searchMatch(matchName : String?) : String{
        return "${BuildConfig.BASE_URL}api/v1/json/${BuildConfig.TSDB_API_KEY}/searchevents.php?e=${matchName}"
    }

    fun getDetailsTeam(idTeam: String?): String{
        return "${BuildConfig.BASE_URL}api/v1/json/${BuildConfig.TSDB_API_KEY}/lookupteam.php?id=${idTeam}"
    }

    fun championship(idLeague: String?): String{
        return "${BuildConfig.BASE_URL}api/v1/json/${BuildConfig.TSDB_API_KEY}/lookuptable.php?l=${idLeague}"
    }

    fun listPlayers(idTeam: String?): String{
        return "${BuildConfig.BASE_URL}api/v1/json/${BuildConfig.TSDB_API_KEY}/lookup_all_players.php?id=${idTeam}"
    }

    fun detailsPlayer(idPlayer: String?): String{
        return "${BuildConfig.BASE_URL}api/v1/json/${BuildConfig.TSDB_API_KEY}/lookupplayer.php?id=${idPlayer}"
    }

    fun nextMatchTeam(idTeam: String?): String{
        return "${BuildConfig.BASE_URL}api/v1/json/${BuildConfig.TSDB_API_KEY}/evenrsnext.php?id=${idTeam}"
    }

    fun lastMatchTeam(idTeam: String?): String{
        return "${BuildConfig.BASE_URL}api/v1/json/${BuildConfig.TSDB_API_KEY}/eventslast.php?id=${idTeam}"
    }

    fun searchTeam(teamName: String?): String{
        return "${BuildConfig.BASE_URL}api/v1/json/${BuildConfig.TSDB_API_KEY}/searchteams.php?t=${teamName}"
    }
}