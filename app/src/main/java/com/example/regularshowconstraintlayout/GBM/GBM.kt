package com.example.regularshowconstraintlayout.GBM

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.regularshowconstraintlayout.MeetTheEboard.EboardAdapterParent
import com.example.regularshowconstraintlayout.R
import com.example.regularshowconstraintlayout.databinding.FragmentEboardBinding
import com.example.regularshowconstraintlayout.databinding.FragmentGBMBinding
import com.example.regularshowconstraintlayout.model.Category
import com.example.regularshowconstraintlayout.model.GBMData
import com.example.regularshowconstraintlayout.model.MemberDetail


class GBM : Fragment() {
    private lateinit var binding: FragmentGBMBinding
    private val adapter = EboardAdapterParent()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGBMBinding.inflate(inflater, container, false)
        val callback = requireActivity().onBackPressedDispatcher.addCallback {
            parentFragmentManager.popBackStack()
        }
        //depending on how you want your list to show
        binding.gbmrecycle.layoutManager = LinearLayoutManager(requireContext())
        binding.gbmrecycle.adapter = adapter
        val items = GBMData.values().toList().map {
            EboardAdapterParent.NewDataItem(
                it.title,
                listOf(MemberDetail("", it.body))
            )
        }
        adapter.setFullData(items)
        binding.searchGBM.setOnQueryTextListener(object:
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