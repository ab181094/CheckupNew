package com.example.checkup.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.checkup.R
import com.example.checkup.activities.HomeActivity
import com.example.checkup.models.ModelIcon
import com.example.checkup.viewholders.IconHolder

class IconAdapter(
    val activity: HomeActivity,
    val iconList: MutableList<ModelIcon>
) :
    RecyclerView.Adapter<IconHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IconHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return IconHolder(layoutInflater.inflate(R.layout.custom_icon, parent, false))
    }

    override fun getItemCount(): Int {
        return iconList.size
    }

    override fun onBindViewHolder(holder: IconHolder, position: Int) {
        val modelIcon = iconList[position]
        holder.imageViewIcon.setImageResource(modelIcon.iconImage!!)
        holder.tvIcon.text = modelIcon.iconName

        holder.iconCard.setOnClickListener {
            activity.navigateMenu(position)
        }
    }
}