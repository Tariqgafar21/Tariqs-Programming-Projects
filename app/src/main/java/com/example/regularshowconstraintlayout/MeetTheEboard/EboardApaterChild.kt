package com.example.regularshowconstraintlayout.MeetTheEboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.regularshowconstraintlayout.databinding.ChildExpandableEboardBinding
import com.example.regularshowconstraintlayout.model.MemberDetail


class EboardApaterChild : RecyclerView.Adapter<EboardApaterChild.DataViewHolder>(){

    val members = mutableListOf<MemberDetail>()

    class DataViewHolder(private val binding: ChildExpandableEboardBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(detail: MemberDetail?) {
            with(binding) {
                names.text = detail?.memberName ?: ""
                quoute.text = detail?.quote ?: ""
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        //decide which design will be displayed
        //val view: View = LayoutInflater.from(parent.context).inflate(R.layout.child_expandable_eboard,parent, false)
        val binding = ChildExpandableEboardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return members.size
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(members.getOrNull(position))
    }

    fun setMembers(list: List<MemberDetail>) {
        members.clear()
        members.addAll(list)
        notifyDataSetChanged()
    }
}

