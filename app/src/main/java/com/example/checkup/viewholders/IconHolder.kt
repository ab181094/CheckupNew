package com.example.checkup.viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.checkup.R

class IconHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val iconCard = itemView.findViewById<CardView>(R.id.iconCard)
    val imageViewIcon = itemView.findViewById<ImageView>(R.id.imageViewIcon)
    val tvIcon = itemView.findViewById<TextView>(R.id.tvIcon)
}