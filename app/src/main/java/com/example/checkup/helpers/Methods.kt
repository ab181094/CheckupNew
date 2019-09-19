package com.example.checkup.helpers

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.checkup.R
import com.example.checkup.fragments.NumberFragment

fun showNumberFragment(activity: AppCompatActivity, layout: Int) {
    val fragment = NumberFragment()
    activity.supportFragmentManager.beginTransaction().replace(R.id.container, fragment, REG_TAG)
        .commit()
}

fun log(message: Any) {
    Log.d("CHECKUP_TEST", message.toString())
}

fun showFragment(activity: AppCompatActivity, fragment: Fragment, container: Int, tag: String) {
    activity.supportFragmentManager.beginTransaction().replace(container, fragment, tag).commit()
}

fun toast(context: Context, message: Any) {
    Toast.makeText(context, message.toString(), Toast.LENGTH_LONG).show()
}

fun error(editText: EditText) {
    editText.error = ERROR_FIELD
    editText.requestFocus()
}

fun saveInfoLocally(activity: Activity, hashMap: LinkedHashMap<String, Any>) {
    val sharedPref = activity.getPreferences(Context.MODE_PRIVATE) ?: return
    with(sharedPref.edit()) {
        for (entry in hashMap.entries) {
            when (entry.value) {
                is String -> {
                    putString(entry.key, entry.value.toString())
                }

                is Int -> {
                    putInt(entry.key, entry.value as Int)
                }
            }
        }
        apply()
    }
}

fun showProgressBar(progressBar: ProgressBar) {
    progressBar.visibility = View.VISIBLE
}

fun hideProgressBar(progressBar: ProgressBar) {
    progressBar.visibility = View.GONE
}