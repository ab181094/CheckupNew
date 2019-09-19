package com.example.checkup.activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.checkup.R
import com.example.checkup.controllers.sendReport
import com.example.checkup.helpers.LOGIN_TAG
import com.example.checkup.helpers.REPORT_TAG
import com.example.checkup.helpers.toast
import com.example.checkup.interfaces.ArrayResponse
import com.example.checkup.models.Doctor

import kotlinx.android.synthetic.main.activity_contact.*
import org.json.JSONArray
import org.json.JSONObject
import java.util.*
import javax.security.auth.Subject
import kotlin.collections.LinkedHashMap

class ContactActivity : AppCompatActivity(), ArrayResponse {

    private lateinit var etSubject: EditText
    private lateinit var etMessage: EditText
    private lateinit var btnSend: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        initAll()

        val contactString = "01857615005"
        etSubject.setText("Android developer")
        etMessage.setText("We need a dexterous android developer")

        btnSend.setOnClickListener {
            val subjectString = etSubject.text.toString().trim()
            val messageString = etMessage.text.toString().trim()

            if (subjectString.isEmpty()) {
                error(etSubject)
            } else if (messageString.isEmpty()) {
                error(etMessage)
            } else {
                val dateString = Calendar.getInstance().time.toString()
                sendReport(this, contactString, subjectString, messageString, dateString)
            }
        }
    }

    private fun initAll() {
        etSubject = findViewById(R.id.etSubject)
        etMessage = findViewById(R.id.etMessage)
        btnSend = findViewById(R.id.btnSend)
    }

    override fun onValuePass(responseList: LinkedHashMap<String, Any>) {
        if (responseList.containsKey(REPORT_TAG)) {
            val response = responseList[LOGIN_TAG].toString()

            toast(this, response)
        }
    }
}
