package com.example.checkup.controllers

import com.example.checkup.activities.DoctorRegActivity
import com.example.checkup.activities.LoginActivity
import com.example.checkup.helpers.*
import com.example.checkup.models.Doctor

fun validateDoctorRegNumber(doctorRegActivity: DoctorRegActivity, numberString: String) {
    val url = "$DOCTOR_REG_VERIFICATION_API?reg=$numberString"
    getStringRequest(doctorRegActivity, url, VERIFY_TAG, VERIFY_TAG)
}

fun registerDoctor(doctorRegActivity: DoctorRegActivity, doctor: Doctor) {
    val url = DOCTOR_REG_API
    postDoctorStringRequest(doctorRegActivity, url, doctor, DOCTOR_REG_TAG, DOCTOR_REG_TAG)
}

fun login(loginActivity: LoginActivity, contactString: String, passwordString: String) {
    val url = LOGIN_API

    val map = HashMap<String, String>()
    map["contact"] = contactString
    map["password"] = passwordString

    postStringRequest(loginActivity, url, map, LOGIN_TAG, LOGIN_TAG)
}