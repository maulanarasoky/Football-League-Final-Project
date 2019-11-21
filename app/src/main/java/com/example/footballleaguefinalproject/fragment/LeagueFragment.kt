package com.example.footballleaguefinalproject.fragment


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager

import com.example.footballleaguefinalproject.R
import com.example.footballleaguefinalproject.adapter.league.LeagueAdapter
import com.example.footballleaguefinalproject.model.league.League
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

/**
 * A simple [Fragment] subclass.
 */
class LeagueFragment : Fragment(), AnkoComponent<Context> {

    private var items : MutableList<League> = mutableListOf()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initData()

    }

    private fun initData(){
        val id = resources.getStringArray(R.array.football_id)
        val name = resources.getStringArray(R.array.football_name)
        val description = resources.getStringArray(R.array.football_description)

        val image = resources.obtainTypedArray(R.array.football_image)
        items.clear()

        for (i in name.indices){
            items.add(
                League(
                    id[i],
                    name[i],
                    description[i],
                    image.getResourceId(i, 0)
                )
            )
        }
        image.recycle()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return createView(AnkoContext.create(requireContext()))
    }

    override fun createView(ui: AnkoContext<Context>): View = with(ui) {
        verticalLayout{
            padding = dip(16)
            lparams(width = matchParent, height = wrapContent)
            recyclerView {
                id = R.id.recyclerView
                layoutManager = GridLayoutManager(context, 2)
                adapter =
                    LeagueAdapter(
                        context,
                        items
                    )
            }.lparams(width = matchParent, height = matchParent)
        }
    }

}
