package com.jbytestudios.bigvutask.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jbytestudios.bigvutask.R
import com.jbytestudios.bigvutask.model.Workshop
import com.jbytestudios.bigvutask.network.ImageManager

class WorkshopAdapter(val context: Context, val workshopList: List<Workshop>): RecyclerView.Adapter<WorkshopAdapter.WorkshopViewHolder>() {

    //ViewHolder for Workshop. Takes in the inflated view and the onClick behavior
    class WorkshopViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var workshopImage: ImageView = itemView.findViewById(R.id.coach_item_image)
        var workshopAuthor: TextView = itemView.findViewById(R.id.coach_item_author)
        var workshopDesc: TextView = itemView.findViewById(R.id.coach_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkshopViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.workshop_list_item_view, parent, false)
        return WorkshopViewHolder(view)
    }

    override fun onBindViewHolder(holder: WorkshopViewHolder, position: Int) {
        ImageManager.loadImage(workshopList[position].imageUrl, holder.workshopImage)
        holder.workshopAuthor.text = workshopList[position].name
        holder.workshopDesc.text = workshopList[position].description
    }

    override fun getItemCount(): Int {
        return workshopList.size
    }
}