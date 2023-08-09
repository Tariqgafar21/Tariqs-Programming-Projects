package com.example.regularshowconstraintlayout.GBM

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import com.example.regularshowconstraintlayout.R


class GBM : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val callback = requireActivity().onBackPressedDispatcher.addCallback {
            parentFragmentManager.popBackStack()
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_g_b_m, container, false)
    }


}