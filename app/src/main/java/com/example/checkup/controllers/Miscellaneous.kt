package com.example.checkup.controllers

import com.example.checkup.activities.ContactActivity
import com.example.checkup.helpers.REPORT_API
import com.example.checkup.helpers.REPORT_TAG


fun sendReport(
    contactActivity: ContactActivity,
    contactString: String,
    subjectString: String,
    messageString: String,
    dateString: String
) {
    val url = REPORT_API

    val map = HashMap<String, String>()
    map["contact"] = contactString
    map["subject"] = subjectString
    map["message"] = messageString
    map["time"] = dateString

    postStringRequest(contactActivity, url, map, REPORT_TAG, REPORT_TAG)
}