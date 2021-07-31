package com.jbytestudios.bigvutask.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jbytestudios.bigvutask.R

//This list only displays the header above the main list
class HeaderAdapter: RecyclerView.Adapter<HeaderAdapter.HeaderViewHolder>() {

    private var workshopCount: Int = 0

    class HeaderViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val workshopDynamicText: TextView = itemView.findViewById(R.id.header_dynamic_text)

        fun Bind(workshopsCount: Int) {
            workshopDynamicText.text = workshopsCount.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.workshop_header_item_view, parent, false)
        return HeaderViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {
        holder.Bind(workshopCount)
    }

    override fun getItemCount(): Int {
        return 1
    }

    fun updateWorkshopCount(updatedWorkshopCount: Int) {
        workshopCount = updatedWorkshopCount
        notifyDataSetChanged()
    }

}