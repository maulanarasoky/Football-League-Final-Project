package com.example.footballleaguefinalproject.activity.team

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.footballleaguefinalproject.R
import com.example.footballleaguefinalproject.adapter.team.ListPlayersAdapter
import com.example.footballleaguefinalproject.api.ApiRepository
import com.example.footballleaguefinalproject.interfaces.team.DetailsTeamView
import com.example.footballleaguefinalproject.model.team.DetailsTeam
import com.example.footballleaguefinalproject.model.team.player.Players
import com.example.footballleaguefinalproject.presenter.team.DetailsTeamPresenter
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_details_team.*
import org.jetbrains.anko.find

class DetailsTeamActivity : AppCompatActivity(),
DetailsTeamView{

    private lateinit var teams: DetailsTeam
    private lateinit var progressBar: ProgressBar
    private lateinit var presenter: DetailsTeamPresenter
    private lateinit var adapter: ListPlayersAdapter

    private val teamsArray: MutableList<DetailsTeam> = mutableListOf()
    private val listPlayers: MutableList<Players> = mutableListOf()

    companion object{
        const val teamId = "teamId"
        const val teamName = "teamName"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_team)

        val title = intent.getStringExtra(teamName)
        val id = intent.getStringExtra(teamId)

        val collapsingToolbar: CollapsingToolbarLayout = find(R.id.collapsingToolbar)
        collapsingToolbar.setExpandedTitleColor(resources.getColor(android.R.color.transparent))

        val toolbar: Toolbar = find(R.id.toolBar)
        setSupportActionBar(toolbar)

        supportActionBar?.title = title

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        progressBar = find(R.id.progressBar)

        val request = ApiRepository()
        val gson = Gson()

        presenter = DetailsTeamPresenter(
            this,
            request,
            gson
        )

        presenter.getDetailsTeam(id)
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun showDetailsTeam(detailsTeam: List<DetailsTeam>?, listPlayers: List<Players>?) {
        this.teamsArray.clear()
        this.listPlayers.clear()
        if (detailsTeam != null) {
            this.teamsArray.addAll(detailsTeam)

            teams = DetailsTeam(
                teamsArray[0].league,
                teamsArray[0].stadium,
                teamsArray[0].website,
                teamsArray[0].facebook,
                teamsArray[0].twitter,
                teamsArray[0].instagram,
                teamsArray[0].description,
                teamsArray[0].teamBadge
            )
            Glide.with(this).load(teams.teamBadge).apply(RequestOptions.overrideOf(500,500)).into(imgHeader)
            leagueName.text = teams.league
            stadiumName.text = teams.stadium
            descriptionTeam.text = teams.description
            websiteTeam.text = teams.website
        }

        if (listPlayers != null) {
            this.listPlayers.addAll(listPlayers)

            adapter = ListPlayersAdapter(this, listPlayers)
            recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            recyclerView.adapter = adapter
        }
    }
}
