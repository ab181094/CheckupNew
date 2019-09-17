package com.example.checkup.activities

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.example.checkup.R
import com.example.checkup.controllers.login
import com.example.checkup.fragments.DoctorRegFragment
import com.example.checkup.helpers.*
import com.example.checkup.interfaces.ArrayResponse
import com.example.checkup.models.Doctor
import org.json.JSONArray
import org.json.JSONObject

class LoginActivity : AppCompatActivity(), View.OnClickListener, ArrayResponse {

    private lateinit var etContact: EditText
    private lateinit var etPassword: EditText
    private lateinit var chkRemember: CheckBox
    private lateinit var progressBar: ProgressBar
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initAll()

        loadLocalData()
    }

    private fun initAll() {
        etContact = findViewById(R.id.etContact)
        etPassword = findViewById(R.id.etPassword)
        chkRemember = findViewById(R.id.chkRemember)
        progressBar = findViewById(R.id.progressBar)
        btnLogin = findViewById(R.id.btnLogin)

        hideProgressBar(progressBar)

        btnLogin.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            btnLogin.id -> {
                val contactString = etContact.text.toString().trim()
                val passwordString = etPassword.text.toString().trim()

                if (chkRemember.isChecked) {
                    val hashMap = LinkedHashMap<String, Any>()
                    hashMap["contact"] = contactString
                    hashMap["password"] = passwordString
                    saveInfoLocally(this, hashMap)
                } else {
                    val sharedPref = getPreferences(Context.MODE_PRIVATE) ?: return

                    with(sharedPref.edit()) {
                        clear()
                        apply()
                    }
                }

                showProgressBar(progressBar)
                login(this, contactString, passwordString)
            }
        }
    }

    private fun loadLocalData() {
        val sharedPref = getPreferences(Context.MODE_PRIVATE) ?: return
        val defaultValue = ""
        val contactString = sharedPref.getString("contact", defaultValue)
        val passwordString = sharedPref.getString("password", defaultValue)

        etContact.setText(contactString)
        etPassword.setText(passwordString)
    }


    override fun onValuePass(responseList: LinkedHashMap<String, Any>) {
        hideProgressBar(progressBar)

        if (responseList.containsKey(LOGIN_TAG)) {
            val response = responseList[LOGIN_TAG].toString()

            if (response != "User not found") {
                val jsonArray = JSONArray(response)
                val jsonObject = jsonArray[0] as JSONObject
                val type = jsonObject.getInt("type")
                val nameString = jsonObject.getString("name")

                toast(this, "Welcome $nameString")

                if (type == 1) {
                    val doctor = Doctor()
                    doctor.nameString = nameString
                    doctor.contactString = jsonObject.getString("contact")
                    doctor.passwordString = jsonObject.getString("password")
                    doctor.regNumberString = jsonObject.getString("reg")
                    doctor.type = type
                }
            } else {
                toast(this, response)
            }
        }
    }
}
