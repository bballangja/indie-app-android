package com.kimthreemun.indieconcertapp.ui.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kimthreemun.indieconcertapp.R
import com.kimthreemun.indieconcertapp.data.model.domain.Performance

class ShowAdapter(private val items: List<Performance>) :
    RecyclerView.Adapter<ShowAdapter.ShowViewHolder>() {

    inner class ShowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivPoster: ImageView = itemView.findViewById(R.id.ivPoster)
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvVenue: TextView = itemView.findViewById(R.id.tvVenue)
        val tvDate: TextView = itemView.findViewById(R.id.tvDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_performance_title_venue_date, parent, false)
        return ShowViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShowViewHolder, position: Int) {
        val item = items[position]

        holder.tvTitle.text = item.title
        holder.tvVenue.text = item.venue
        holder.tvDate.text = item.date

        Glide.with(holder.itemView).load(item.posterUrl).into(holder.ivPoster)

    }

    override fun getItemCount(): Int = items.size
}
