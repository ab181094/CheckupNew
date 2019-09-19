package com.example.checkup.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.checkup.R
import com.example.checkup.activities.ProfileActivity
import com.example.checkup.models.Twin
import com.example.checkup.viewholders.PropertyHolder

class PropertyAdapter(
    val activity: ProfileActivity,
    val propertyList: MutableList<Twin>
) :
    RecyclerView.Adapter<PropertyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PropertyHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PropertyHolder(layoutInflater.inflate(R.layout.custom_profile, parent, false))
    }

    override fun getItemCount(): Int {
        return propertyList.size
    }

    override fun onBindViewHolder(holder: PropertyHolder, position: Int) {
        val twin = propertyList[position]
        holder.tvProperty.text = twin.propertyString

        if (twin.propertyString == "Password") {
            val valueString = twin.valueObject.toString().trim()
            var passwordString = ""

            for (i in 0 until valueString.length) {
                passwordString += "*"
            }

            holder.tvValue.text = passwordString
        } else {
            holder.tvValue.text = twin.valueObject.toString()
        }
    }
}