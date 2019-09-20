package com.example.checkup.adapters

import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.checkup.R
import com.example.checkup.activities.TipsActivity
import com.example.checkup.models.Twin
import com.example.checkup.viewholders.TipsHolder

class TipsAdapter(
    val activity: TipsActivity,
    val tipsList: MutableList<Twin>
) :
    RecyclerView.Adapter<TipsHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipsHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return TipsHolder(layoutInflater.inflate(R.layout.custom_tips, parent, false))
    }

    override fun getItemCount(): Int {
        return tipsList.size
    }

    override fun onBindViewHolder(holder: TipsHolder, position: Int) {
        val twin = tipsList[position]
        holder.tvHeadline.text = Html.fromHtml(twin.propertyString, Html.FROM_HTML_MODE_LEGACY)
        holder.tvNews.text = Html.fromHtml(twin.valueObject.toString(), Html.FROM_HTML_MODE_LEGACY)

        holder.tipsCard.setOnClickListener {
            activity.showTips(position)
        }
    }
}