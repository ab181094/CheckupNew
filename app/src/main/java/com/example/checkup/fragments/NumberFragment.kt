package com.example.checkup.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText

import com.example.checkup.R
import com.example.checkup.activities.DoctorRegActivity
import com.example.checkup.helpers.DEMO_REG_NO
import com.example.checkup.helpers.DOCTOR_REG_NUMBER

class NumberFragment : Fragment() {
    lateinit var etReg: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_number, container, false)

        initAll(rootView)
        setHint()
        etReg.setText(DEMO_REG_NO)

        return rootView
    }

    private fun setHint() {
        if (activity is DoctorRegActivity)
            etReg.hint = DOCTOR_REG_NUMBER
    }

    private fun initAll(rootView: View) {
        etReg = rootView.findViewById(R.id.etReg)
    }
}
