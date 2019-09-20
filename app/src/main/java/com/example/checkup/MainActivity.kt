package com.example.checkup

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.checkup.activities.HomeActivity
import com.example.checkup.activities.LoginActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quoteArray = resources.getStringArray(R.array.quote_array)
        val limit = quoteArray.size
        val quotePosition = (0..limit).random()
        val quoteString = quoteArray[quotePosition]

        val tvQuote = findViewById<TextView>(R.id.tvQuote)
        tvQuote.text = quoteString

        Handler().postDelayed({
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, 1500)
    }
}
