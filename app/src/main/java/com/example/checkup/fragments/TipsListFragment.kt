package com.example.checkup.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.checkup.R
import com.example.checkup.activities.TipsActivity
import com.example.checkup.adapters.TipsAdapter

/**
 * A simple [Fragment] subclass.
 */
class TipsListFragment : Fragment() {
    private lateinit var tipsRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_tips_list, container, false)

        tipsRecyclerView = rootView.findViewById(R.id.tipsRecyclerView)
        tipsRecyclerView.setHasFixedSize(true)
        tipsRecyclerView.layoutManager = LinearLayoutManager(activity)
        tipsRecyclerView.adapter =
            TipsAdapter((activity as TipsActivity), (activity as TipsActivity).tipsList)

        return rootView
    }
}
