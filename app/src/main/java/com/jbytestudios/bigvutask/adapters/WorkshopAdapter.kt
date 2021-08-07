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
import com.jbytestudios.bigvutask.network.media.ImageManager

class WorkshopAdapter(private val context: Context, private val workshopList: List<Workshop>): RecyclerView.Adapter<WorkshopAdapter.WorkshopViewHolder>() {

    var onItemClick: ((Workshop) -> Unit)? = null

    //ViewHolder for Workshop. Takes in the inflated view and the onClick behavior
    inner class WorkshopViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var workshopImage: ImageView = itemView.findViewById(R.id.coach_item_image)
        var workshopAuthor: TextView = itemView.findViewById(R.id.coach_item_author)
        var workshopDesc: TextView = itemView.findViewById(R.id.coach_item_description)

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(workshopList[bindingAdapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkshopViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.workshop_list_item_view, parent, false)
        return WorkshopViewHolder(view)
    }

    override fun onBindViewHolder(holder: WorkshopViewHolder, position: Int) {
        ImageManager.loadRoundedImage(workshopList[position].imageUrl, holder.workshopImage)
        holder.workshopAuthor.text = workshopList[position].name
        holder.workshopDesc.text = workshopList[position].description
    }

    override fun getItemCount(): Int {
        return workshopList.size
    }
}