package com.example.regularshowconstraintlayout.MeetTheEboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
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
        adapter.setData(Category.values().toList())

        return binding.root

    }
}
