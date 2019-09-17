package com.example.checkup.controllers

import com.example.checkup.activities.DoctorRegActivity
import com.example.checkup.helpers.DOCTOR_REG_API
import com.example.checkup.helpers.DOCTOR_REG_TAG
import com.example.checkup.helpers.DOCTOR_REG_VERIFICATION_API
import com.example.checkup.helpers.VERIFY_TAG
import com.example.checkup.models.Doctor

fun validateDoctorRegNumber(doctorRegActivity: DoctorRegActivity, numberString: String) {
    val url = "$DOCTOR_REG_VERIFICATION_API?reg=$numberString"
    getStringRequest(doctorRegActivity, url, VERIFY_TAG, VERIFY_TAG)
}

fun registerDoctor(doctorRegActivity: DoctorRegActivity, doctor: Doctor) {
    val url = DOCTOR_REG_API
    postStringRequest(doctorRegActivity, url, doctor, DOCTOR_REG_TAG, DOCTOR_REG_TAG)
}
