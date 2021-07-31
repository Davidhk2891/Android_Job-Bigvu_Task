package com.jbytestudios.bigvutask.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.jbytestudios.bigvutask.R
import com.jbytestudios.bigvutask.model.Workshop
import com.jbytestudios.bigvutask.network.ImageManager

class WorkshopAdapter(private val onClick: (Workshop) -> Unit): ListAdapter<Workshop, WorkshopAdapter.WorkshopViewHolder>(WorkshopsDiffCallback) {

    //ViewHolder for Workshop. Takes in the inflated view and the onClick behavior
    class WorkshopViewHolder(itemView: View, val onClick: (Workshop) -> Unit) : RecyclerView.ViewHolder(itemView) {
        private val workshopImage: ImageView = itemView.findViewById(R.id.coach_item_image)
        private val workshopAuthor: TextView = itemView.findViewById(R.id.coach_item_author)
        private val workshopDesc: TextView = itemView.findViewById(R.id.coach_item_description)
        private var currentWorkshop: Workshop? = null

        init {
            itemView.setOnClickListener{
                currentWorkshop?.let{
                    onClick(it)
                }
            }
        }

        //Bind workshop author name, description and image
        fun Bind(workshop: Workshop) {
            currentWorkshop = workshop

            workshopAuthor.text = workshop.name
            workshopDesc.text = workshop.description
            if (workshop.imageUrl.isNotEmpty()) {
                ImageManager.loadRoundedImage(workshop.imageUrl, workshopImage)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkshopViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.workshop_list_item_view, parent, false)
        return WorkshopViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: WorkshopViewHolder, position: Int) {
        val workshop = getItem(position)
        holder.Bind(workshop)
    }

    object WorkshopsDiffCallback : DiffUtil.ItemCallback<Workshop>() {
        override fun areItemsTheSame(oldItem: Workshop, newItem: Workshop): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Workshop, newItem: Workshop): Boolean {
            return oldItem.name == newItem.name
        }

    }
}