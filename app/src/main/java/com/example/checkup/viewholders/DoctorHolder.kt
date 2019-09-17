package com.example.checkup.viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.checkup.R

class DoctorHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val imageView = itemView.findViewById<ImageView>(R.id.imageView)
    val tvName = itemView.findViewById<TextView>(R.id.tvName)
    val tvSpeciality = itemView.findViewById<TextView>(R.id.tvSpeciality)
    val tvRating = itemView.findViewById<TextView>(R.id.tvRating)
    val tvFee = itemView.findViewById<TextView>(R.id.tvFee)
}