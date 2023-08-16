package com.example.regularshowconstraintlayout.MeetTheEboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.regularshowconstraintlayout.databinding.CardDesign2Binding
import com.example.regularshowconstraintlayout.model.MemberDetail
import retrofit2.http.Body
import java.util.Locale


class EboardAdapterParent: RecyclerView.Adapter<EboardAdapterParent.BoardViewHolder>() {

    private val data = mutableListOf<NewDataItem>()
    private val fullData = mutableListOf<NewDataItem>()

    private var selectedIndex = -1

    private val clickListener = object : AdapterClickListener<NewDataItem> {
        override fun onClick(data: NewDataItem?, index: Int) {
            if (selectedIndex != -1) {
                notifyItemChanged(selectedIndex)
            }
            selectedIndex = if (index == selectedIndex) -1 else index
            notifyItemChanged(index)
        }
    }

    class BoardViewHolder(private val binding: CardDesign2Binding, private val listener: AdapterClickListener<NewDataItem>) : RecyclerView.ViewHolder(binding.root){

        val adapter = EboardApaterChild()
        private var index = -1
        private var currentData: NewDataItem? = null

//        var textViewEboardname: TextView = itemView.findViewById(R.id.groupName)
//        var imageView: CircleImageView = itemView.findViewById(R.id.Eboardimage)

        init {
            binding.child.adapter = adapter
            binding.child.layoutManager = LinearLayoutManager(binding.root.context)
            itemView.setOnClickListener {
                listener.onClick(currentData, index)
            }
        }


        fun bind(item: NewDataItem, index: Int, expanded: Boolean) {
            //should this for the groups instead?
            //change the ID
            binding.groupName.text = item.title
            adapter.setMembers(item.members)
            this.index = index
            this.currentData = item

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
        data.getOrNull(position)?.let { item ->
            holder.bind(item, position, position == selectedIndex)
        }
    }


    fun setFullData(list: List<NewDataItem>) {
        fullData.clear()
        fullData.addAll(list)
        setData(fullData)
    }

    private fun setData(list: List<NewDataItem>){
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }
//    fun filterQuery(searchText: String) {
//        val newList = fullData.filter {
//            it.group.toLowerCase().contains(searchText.toLowerCase()) ||
//        }
//        setData(newList)
//    }
fun filterQuery(searchText: String) {
    val newList = fullData.filter {
        val combinedString = "${it.title} ${it.members}".lowercase(Locale.getDefault())
        combinedString.contains(searchText.lowercase(Locale.getDefault()))
    }
    setData(newList)
}
    data class NewDataItem(val title: String,val members: List<MemberDetail>,val body: String="")
        
    
}