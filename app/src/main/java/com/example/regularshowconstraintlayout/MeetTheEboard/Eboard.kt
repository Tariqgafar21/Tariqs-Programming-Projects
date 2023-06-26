package com.example.regularshowconstraintlayout.MeetTheEboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import com.example.regularshowconstraintlayout.R

class Eboard : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val callback = requireActivity().onBackPressedDispatcher.addCallback {
            parentFragmentManager.popBackStack()
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_eboard, container, false)
    }

}