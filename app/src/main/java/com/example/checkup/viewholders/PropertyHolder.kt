package com.example.checkup.viewholders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.checkup.R

class PropertyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvProperty = itemView.findViewById<TextView>(R.id.tvProperty)
    val tvValue = itemView.findViewById<TextView>(R.id.tvValue)
}