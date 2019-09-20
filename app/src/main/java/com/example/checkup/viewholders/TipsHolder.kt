package com.example.checkup.viewholders

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.checkup.R

class TipsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tipsCard = itemView.findViewById<CardView>(R.id.tipsCard)
    val tvHeadline = itemView.findViewById<TextView>(R.id.tvHeadline)
    val tvNews = itemView.findViewById<TextView>(R.id.tvNews)
}