package com.example.regularshowconstraintlayout.Convention

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import com.example.regularshowconstraintlayout.R
import androidx.databinding.DataBindingUtil
import com.example.regularshowconstraintlayout.databinding.FragmentConventionBinding


class ConventionFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val callback = requireActivity().onBackPressedDispatcher.addCallback {
            parentFragmentManager.popBackStack()
        }
        val binding = FragmentConventionBinding.inflate(inflater,container,false)


        // Inflate the layout for this fragment
        return binding.root
    }


}