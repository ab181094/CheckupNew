package com.example.checkup.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.checkup.R
import com.example.checkup.adapters.IconAdapter
import com.example.checkup.models.ModelIcon

class HomeActivity : AppCompatActivity() {
    private lateinit var iconRecyclerView: RecyclerView
    private lateinit var iconList: MutableList<ModelIcon>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initAll()
        setIcons()
        startAdapter()
    }

    private fun startAdapter() {
        iconRecyclerView.setHasFixedSize(true)
        iconRecyclerView.layoutManager = GridLayoutManager(this, 2)
        iconRecyclerView.adapter = IconAdapter(this, iconList)
    }

    private fun setIcons() {
        createIcon("Doctor", R.drawable.ic_doctor)
        createIcon("Dianostics", R.drawable.ic_cardiogram)
        createIcon("Hospitals", R.drawable.ic_hospital)
        createIcon("Blood Banks", R.drawable.ic_heart)
        createIcon("Ambulances", R.drawable.ic_ambulance)
        createIcon("Health Tips", R.drawable.ic_aids)
        createIcon("History", R.drawable.ic_report)
        createIcon("Profile", R.drawable.ic_user)
        createIcon("Appointments", R.drawable.ic_calendar)
        createIcon("Contact Us", R.drawable.ic_phone)
        createIcon("Sign Out", R.drawable.ic_logout)
    }

    private fun createIcon(iconName: String, iconImage: Int) {
        val modelIcon = ModelIcon()
        modelIcon.iconName = iconName
        modelIcon.iconImage = iconImage

        iconList.add(modelIcon)
    }

    private fun initAll() {
        iconRecyclerView = findViewById(R.id.iconRecyclerView)
        iconList = mutableListOf()
    }

    fun navigateMenu(position: Int) {
        val modelIcon = iconList[position]

        when (modelIcon.iconName) {
            "Doctor" -> {
                val intent = Intent(this, ShowDoctorsActivity::class.java)
                startActivity(intent)
            }

            "Dianostics" -> {
                val intent = Intent(this, ShowDiagnosticsActivity::class.java)
                startActivity(intent)
            }

            "Hospitals" -> {
                val intent = Intent(this, HospitalsActivity::class.java)
                startActivity(intent)
            }

            "Blood Banks" -> {
                val intent = Intent(this, BloodBanksActivity::class.java)
                startActivity(intent)
            }

            "Ambulances" -> {
                val intent = Intent(this, AmbulancesActivity::class.java)
                startActivity(intent)
            }

            "Health Tips" -> {
                val intent = Intent(this, TipsActivity::class.java)
                startActivity(intent)
            }

            "History" -> {
                val intent = Intent(this, HistoryActivity::class.java)
                startActivity(intent)
            }

            "Profile" -> {
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
            }

            "Appointments" -> {
                val intent = Intent(this, AppointmentsActivity::class.java)
                startActivity(intent)
            }

            "Contact Us" -> {
                val intent = Intent(this, ContactActivity::class.java)
                startActivity(intent)
            }

            "Sign Out" -> {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}
