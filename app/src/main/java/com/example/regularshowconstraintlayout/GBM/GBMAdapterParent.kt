package com.example.regularshowconstraintlayout.GBM

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.regularshowconstraintlayout.MeetTheEboard.AdapterClickListener
import com.example.regularshowconstraintlayout.databinding.CardDesign2Binding
import com.example.regularshowconstraintlayout.model.Category

class GBMAdapterParent: RecyclerView.Adapter<GBMAdapterParent.ScheduleViewHolder>() {
    private var selectedIndex = -1
    private val clickListener = object : AdapterClickListener<Category> {
        override fun onClick(data: Category?, index: Int) {
            if (selectedIndex != -1) {
                notifyItemChanged(selectedIndex)
            }
            selectedIndex = if (index == selectedIndex) -1 else index
            notifyItemChanged(index)
        }
    }


    class ScheduleViewHolder(private val binding: CardDesign2Binding, private val listener: AdapterClickListener<Category>) : RecyclerView.ViewHolder(binding.root){
        val adapter = GBMAdapterChild()
        private var index = -1
        private var currentData: Category? = null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}