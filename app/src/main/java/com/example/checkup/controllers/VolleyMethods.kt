package com.example.checkup.controllers

import androidx.appcompat.app.AppCompatActivity
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.example.checkup.helpers.APISingleton
import com.example.checkup.helpers.log
import com.example.checkup.interfaces.ArrayResponse
import com.example.checkup.models.Doctor

fun getStringRequest(
    activity: AppCompatActivity,
    url: String,
    responseCode: String,
    tag: String
) {
    val arrayResponse = activity as ArrayResponse

    log(url)

    val stringRequest = StringRequest(
        Request.Method.GET, url,
        Response.Listener<String> { response ->
            log(response)
            val valueMap = LinkedHashMap<String, Any>()
            valueMap[responseCode] = response
            arrayResponse.onValuePass(valueMap)
        },
        Response.ErrorListener {
            val valueMap = LinkedHashMap<String, Any>()
            valueMap["volleyError"] = ""
            arrayResponse.onValuePass(valueMap)
        })

    APISingleton.getInstance(activity).addToRequestQueue(stringRequest, tag)
}


fun postDoctorStringRequest(
    activity: AppCompatActivity,
    url: String,
    doctor: Doctor,
    responseCode: String,
    tag: String
) {
    val arrayResponse = activity as ArrayResponse

    val stringRequest = object : StringRequest(
        Method.POST, url,
        Response.Listener<String> { response ->
            val valueMap = LinkedHashMap<String, Any>()
            valueMap[responseCode] = response
            arrayResponse.onValuePass(valueMap)
        },
        Response.ErrorListener {
            val valueMap = LinkedHashMap<String, Any>()
            valueMap["volleyError"] = ""
            arrayResponse.onValuePass(valueMap)
        }) {
        @Throws(AuthFailureError::class)
        override fun getParams(): Map<String, String> {
            val hashMap = HashMap<String, String>()
            hashMap["name"] = doctor.nameString!!
            hashMap["contact"] = doctor.contactString!!
            hashMap["password"] = doctor.passwordString!!
            hashMap["reg"] = doctor.regNumberString!!
            hashMap["type"] = doctor.type.toString()
            return hashMap
        }
    }
    APISingleton.getInstance(activity).addToRequestQueue(stringRequest, tag)
}

fun postStringRequest(
    activity: AppCompatActivity,
    url: String,
    map: HashMap<String, String>,
    responseCode: String,
    tag: String
) {
    val arrayResponse = activity as ArrayResponse

    val stringRequest = object : StringRequest(
        Method.POST, url,
        Response.Listener<String> { response ->
            val valueMap = LinkedHashMap<String, Any>()
            valueMap[responseCode] = response
            arrayResponse.onValuePass(valueMap)
        },
        Response.ErrorListener {
            val valueMap = LinkedHashMap<String, Any>()
            valueMap["volleyError"] = ""
            arrayResponse.onValuePass(valueMap)
        }) {
        @Throws(AuthFailureError::class)
        override fun getParams(): Map<String, String> {
            return map
        }
    }
    APISingleton.getInstance(activity).addToRequestQueue(stringRequest, tag)
}
