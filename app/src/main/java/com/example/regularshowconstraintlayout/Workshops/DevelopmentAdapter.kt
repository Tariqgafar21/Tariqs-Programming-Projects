package com.example.regularshowconstraintlayout.Workshops

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.regularshowconstraintlayout.R

class DevelopmentAdapter(private val workshopsList: ArrayList<Development> )
    : RecyclerView.Adapter<DevelopmentAdapter.WorkshopsViewHolder>(){

    class WorkshopsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val imageView : ImageView = itemView.findViewById(R.id.gridImage)
        val textView: TextView = itemView.findViewById(R.id.gridText)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkshopsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_design_grid,parent,false)
        return WorkshopsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return workshopsList.size
    }

    override fun onBindViewHolder(holder: WorkshopsViewHolder, position: Int) {
        val workshops = workshopsList[position]
        holder.imageView.setImageResource(workshops.image)
        holder.textView.text = workshops.names
    }
}