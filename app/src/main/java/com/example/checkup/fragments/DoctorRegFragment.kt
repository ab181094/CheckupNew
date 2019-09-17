package com.example.checkup.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText

import com.example.checkup.R

class DoctorRegFragment : Fragment() {
    lateinit var etName: EditText
    lateinit var etContact: EditText
    lateinit var etPassword: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_doctor_reg, container, false)

        initAll(rootView)

        etName.setText("Sugata")
        etContact.setText("0186767676")
        etPassword.setText("Sugata")

        return rootView
    }

    private fun initAll(rootView: View) {
        etName = rootView.findViewById(R.id.etName)
        etContact = rootView.findViewById(R.id.etContact)
        etPassword = rootView.findViewById(R.id.etPassword)
    }
}
