package com.example.checkup.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.checkup.R
import com.example.checkup.activities.ProfileActivity
import com.example.checkup.adapters.PropertyAdapter

/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : Fragment() {
    lateinit var profileImageView: ImageView
    lateinit var infoRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_profile, container, false)

        initAll(rootView)

        infoRecyclerView.setHasFixedSize(true)
        infoRecyclerView.layoutManager = LinearLayoutManager(activity)
        infoRecyclerView.adapter = PropertyAdapter(activity as ProfileActivity, (activity as ProfileActivity).profileInfoList)

        return rootView
    }

    private fun initAll(rootView: View) {
        profileImageView = rootView.findViewById(R.id.profile_image)
        infoRecyclerView = rootView.findViewById(R.id.infoRecyclerView)
    }
}
