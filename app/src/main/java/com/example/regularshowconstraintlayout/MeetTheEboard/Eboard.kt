package com.example.regularshowconstraintlayout.MeetTheEboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.regularshowconstraintlayout.databinding.FragmentEboardBinding
import com.example.regularshowconstraintlayout.model.Category

class Eboard : Fragment() {


    private val adapter = EboardAdapterParent()

    lateinit var binding: FragmentEboardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEboardBinding.inflate(inflater, container, false)
        val callback = requireActivity().onBackPressedDispatcher.addCallback {
            parentFragmentManager.popBackStack()
        }
        //depending on how you want your list to show
        binding.EboardRecycle.layoutManager = LinearLayoutManager(requireContext())
        binding.EboardRecycle.adapter = adapter
        val items = Category.values().toList().map {
            EboardAdapterParent.NewDataItem(
                it.group,
                it.detail.members
            )
        }
        adapter.setFullData(items)
        binding.search.setOnQueryTextListener(object:
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                Log.e("test",newText.toString())
                adapter.filterQuery(newText.orEmpty())
                return true
            }


        })




        return binding.root


    }
}
