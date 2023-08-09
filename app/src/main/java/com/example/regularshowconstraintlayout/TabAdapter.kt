package com.example.regularshowconstraintlayout

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class TabAdapter(var tabNameList: ArrayList<String>, var context: Context, val listener: ViewHolderClickListener) :
    RecyclerView.Adapter<TabAdapter.TabViewHolder>() {

    class TabViewHolder(itemView: View, private val listener: ViewHolderClickListener) : RecyclerView.ViewHolder(itemView) {

        var textViewTabName: TextView = itemView.findViewById(R.id.gridText)
        var cardView: CardView = itemView.findViewById(R.id.grid_card)

        init {
            //method that gets called
            cardView.setOnClickListener {
                listener.onVHClicked(textViewTabName.text.toString())
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TabViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.card_design_grid, parent, false)
        return TabViewHolder(view, listener)
    }

    override fun getItemCount(): Int {


        return tabNameList.size
    }

    override fun onBindViewHolder(holder: TabViewHolder, position: Int) {

        holder.textViewTabName.text = tabNameList.get(position)

        /*
        holder.cardView.setOnClickListener {
            Toast.makeText(context, tabNameList.get(position), Toast.LENGTH_LONG)
        }
        */
    }

}

interface ViewHolderClickListener {
    fun onVHClicked(name: String)
}