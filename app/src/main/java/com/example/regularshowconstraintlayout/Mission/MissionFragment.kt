package com.example.regularshowconstraintlayout.Mission

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import com.example.regularshowconstraintlayout.R
import com.example.regularshowconstraintlayout.databinding.FragmentMissionBinding


class MissionFragment() : Fragment() {


    //I normally hate lateinit, but it's okay for this
    //private lateinit var binding: FragmentMissionBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        //Toast.makeText(requireContext(),"ahahahaha",Toast.LENGTH_SHORT).show()
        val callback = requireActivity().onBackPressedDispatcher.addCallback {
            parentFragmentManager.popBackStack()
        }

        /*return FragmentMissionBinding.inflate(inflater, container, false).apply {
            //run this code inside apply before returning
            binding = this

         */
        return inflater.inflate(R.layout.fragment_mission,container,false)
        }

    }



