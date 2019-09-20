package com.example.checkup.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.checkup.R
import com.example.checkup.models.Twin

/**
 * A simple [Fragment] subclass.
 */
class TipsDetailsFragment : Fragment() {
    private lateinit var tvHeadlineDetails: TextView
    private lateinit var tvNewsDetails: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_tips_details, container, false)

        initAll(rootView)

        val bundle = arguments

        if (bundle != null) {
            val twin = bundle.getParcelable("twin") as Twin?

            tvHeadlineDetails.text = twin?.propertyString
            tvNewsDetails.text = twin?.valueObject.toString()
        }

        return rootView
    }

    private fun initAll(rootView: View) {
        tvHeadlineDetails = rootView.findViewById(R.id.tvHeadlineDetails)
        tvNewsDetails = rootView.findViewById(R.id.tvNewsDetails)
    }
}
