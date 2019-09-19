package com.example.checkup.activities

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.checkup.R
import com.example.checkup.fragments.ProfileFragment
import com.example.checkup.helpers.PROFILE_TAG
import com.example.checkup.helpers.showFragment
import com.example.checkup.models.Doctor
import com.example.checkup.models.Twin

import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    lateinit var profileInfoList: MutableList<Twin>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        initAll()

        val doctor = Doctor()
        doctor.nameString = "Dr. Rivu Raj Chakraborty"
        doctor.contactString = "01857615005"
        doctor.passwordString = "rivuraj"
        doctor.regNumberString = "110011"

        createProperty("Name", doctor.nameString!!)
        createProperty("Contact", doctor.contactString!!)
        createProperty("Password", doctor.passwordString!!)
        createProperty("Registration Number", doctor.regNumberString!!)

        val profileFragment = ProfileFragment()
        showFragment(this, profileFragment, R.id.profileContainer, PROFILE_TAG)
    }

    private fun createProperty(propertyName: String, valueObject: Any) {
        val twin = Twin()
        twin.propertyString = propertyName
        twin.valueObject = valueObject
        profileInfoList.add(twin)
    }

    private fun initAll() {
        profileInfoList = mutableListOf()
    }
}
