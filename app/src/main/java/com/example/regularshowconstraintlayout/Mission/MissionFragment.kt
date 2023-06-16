package com.example.regularshowconstraintlayout.Mission

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.regularshowconstraintlayout.R
import com.example.regularshowconstraintlayout.databinding.FragmentMissionBinding

class MissionFragment() : Fragment() {


    //I normally hate lateinit, but it's okay for this
    private lateinit var binding: FragmentMissionBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        return FragmentMissionBinding.inflate(inflater, container, false).apply {
            //run this code inside apply before returning
            binding = this
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}