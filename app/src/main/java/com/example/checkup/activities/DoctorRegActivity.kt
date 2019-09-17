package com.example.checkup.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.checkup.R
import com.example.checkup.controllers.registerDoctor
import com.example.checkup.controllers.validateDoctorRegNumber
import com.example.checkup.fragments.DoctorRegFragment
import com.example.checkup.fragments.NumberFragment
import com.example.checkup.helpers.*
import com.example.checkup.interfaces.ArrayResponse
import com.example.checkup.models.Doctor
import kotlinx.android.synthetic.main.activity_doctor_reg.*

class DoctorRegActivity : AppCompatActivity(), ArrayResponse {
    private var regNumberString = ""
    private var nameString = ""
    private var contactString = ""
    private var passwordString = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor_reg)
        setSupportActionBar(toolbar)

        showNumberFragment(this, R.id.container)

        fab.setOnClickListener { view ->
            val fragment = supportFragmentManager.findFragmentById(R.id.container)
            if (fragment is NumberFragment) {
                regNumberString = fragment.etReg.text.toString().trim()
                validateDoctorRegNumber(this, regNumberString)
            } else if (fragment is DoctorRegFragment) {
                nameString = fragment.etName.toString().trim()
                contactString = fragment.etContact.toString().trim()
                passwordString = fragment.etPassword.toString().trim()

                when {
                    nameString.isEmpty() -> error(fragment.etName)
                    contactString.isEmpty() -> error(fragment.etContact)
                    passwordString.isEmpty() -> error(fragment.etPassword)
                    else -> {
                        val doctor = Doctor()
                        doctor.nameString = nameString
                        doctor.contactString = contactString
                        doctor.passwordString = passwordString
                        doctor.regNumberString = regNumberString
                        doctor.type = 1

                        registerDoctor(this, doctor)
                    }
                }
            }
        }
    }

    override fun onValuePass(responseList: LinkedHashMap<String, Any>) {
        if (responseList.containsKey(VERIFY_TAG)) {
            val response = responseList[VERIFY_TAG].toString()

            if (response.toLowerCase() == "found") {
                val fragment = DoctorRegFragment()
                showFragment(this, fragment, R.id.container, DOCTOR_REG_TAG)
            } else {
                toast(this, "You are not in the database")
            }
        } else if (responseList.containsKey(DOCTOR_REG_TAG)) {
            val response = responseList[DOCTOR_REG_TAG].toString()

            toast(this, response)
        }
    }
}
