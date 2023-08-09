package com.example.regularshowconstraintlayout.Workshops

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.regularshowconstraintlayout.R
import com.example.regularshowconstraintlayout.databinding.FragmentWorkshopsBinding


class Workshops : Fragment() {
//private lateinit var recyclerView: RecyclerView
private lateinit var workshopsList : ArrayList<Development>
private lateinit var developmentAdapter: DevelopmentAdapter
private lateinit var binding: FragmentWorkshopsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWorkshopsBinding.inflate(inflater, container, false)

        binding.WorkRV.setHasFixedSize(true)
        binding.WorkRV.layoutManager = GridLayoutManager(requireContext(), 2)

        workshopsList = ArrayList()


        workshopsList.add(Development(R.drawable.img_6, "LinkedIn Workshops"))
        workshopsList.add(Development(R.drawable.img_7, "Resume Building"))
        workshopsList.add(Development(R.drawable.img_8, "Everything Handshake"))
        workshopsList.add(Development(R.drawable.img_9, "Your Network is your Networth"))
        workshopsList.add(Development(R.drawable.img_4, "Convention Prep"))
        workshopsList.add(Development(R.drawable.img_10, "Campus Life"))

        developmentAdapter = DevelopmentAdapter(workshopsList)
        binding.WorkRV.adapter = developmentAdapter
        val callback = requireActivity().onBackPressedDispatcher.addCallback {
            parentFragmentManager.popBackStack()
        }
        // Inflate the layout for this fragment
        return binding.root
    }

}