package com.example.regularshowconstraintlayout.MeetTheEboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.regularshowconstraintlayout.R
import com.example.regularshowconstraintlayout.databinding.CardDesign2Binding
import com.example.regularshowconstraintlayout.model.Category
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.coroutines.selects.select


class EboardAdapterParent: RecyclerView.Adapter<EboardAdapterParent.BoardViewHolder>() {

    private val data = mutableListOf<Category>()

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

    class BoardViewHolder(private val binding: CardDesign2Binding, private val listener: AdapterClickListener<Category>) : RecyclerView.ViewHolder(binding.root){

        val adapter = EboardApaterChild()
        private var index = -1
        private var currentData: Category? = null

//        var textViewEboardname: TextView = itemView.findViewById(R.id.groupName)
//        var imageView: CircleImageView = itemView.findViewById(R.id.Eboardimage)

        init {
            binding.child.adapter = adapter
            binding.child.layoutManager = LinearLayoutManager(binding.root.context)
            itemView.setOnClickListener {
                listener.onClick(currentData, index)
            }
        }


        fun bind(categories: Category, index: Int, expanded: Boolean) {
            //should this for the groups instead?
            binding.groupName.text = categories.group
            adapter.setMembers(categories.detail.members)
            this.index = index
            this.currentData = categories

            binding.expandableList.visibility = if (expanded) View.VISIBLE else View.GONE
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        //inflate the PVH design
        //val view: View = LayoutInflater.from(parent.context).inflate(R.layout.card_design2,parent, false)
        val binding = CardDesign2Binding.inflate(LayoutInflater.from(parent.context), parent, false)

        return BoardViewHolder(binding, clickListener)
    }

    override fun getItemCount(): Int {
        //should i create a list for the group names and then call the size?
       return data.size
    }

    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        //updates the viewHolder contents with the item at that position
        //this is the PVH so i want it to update with the group name contents
        data.getOrNull(position)?.let { category ->
            holder.bind(category, position, position == selectedIndex)
        }
    }


    fun setData(list: List<Category>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }
}