package com.example.regularshowconstraintlayout.optionlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.regularshowconstraintlayout.Convention.ConventionFragment
import com.example.regularshowconstraintlayout.Fundraiser.FundraiserFragment
import com.example.regularshowconstraintlayout.Mission.MissionFragment
import com.example.regularshowconstraintlayout.R
import com.example.regularshowconstraintlayout.TabAdapter
import com.example.regularshowconstraintlayout.ViewHolderClickListener
import com.example.regularshowconstraintlayout.databinding.FragmentOptionListBinding
import com.example.regularshowconstraintlayout.list.ListFragment


class OptionListFragment : Fragment(), ViewHolderClickListener{

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentOptionListBinding.inflate(inflater,container,false)
        val tabNameList = ArrayList<String>()
        tabNameList.add("Our Mission")
        tabNameList.add("General Body Information")
        tabNameList.add("Convention Information")
        tabNameList.add("Fundraiser Events")
        tabNameList.add("Members of the Month")
        tabNameList.add("Meet The Eboard!")
        tabNameList.add("Workshops")
        tabNameList.add("Member dues/information")
        tabNameList.add("Social media")
        val adapter = TabAdapter(tabNameList, requireContext(), this)

        binding.Recycle.adapter = adapter
        return binding.root

    }

    override fun onVHClicked(name: String) {
        gotoNewFragment(name)
        Toast.makeText(requireContext(), name, Toast.LENGTH_SHORT).show()

    }
    private fun gotoNewFragment(name: String) {
        when (name) {
            "Our Mission" -> {
                val transaction = childFragmentManager.beginTransaction()
                transaction.add(MissionFragment(),MissionFragment::class.java.simpleName)
                transaction.commitAllowingStateLoss()

            }

            "General Body Information" -> {
                val transaction = childFragmentManager.beginTransaction()
                transaction.add(MissionFragment(),MissionFragment::class.java.simpleName)
                transaction.commitAllowingStateLoss()
            }

            "Convention Information" -> {
                val transaction = childFragmentManager.beginTransaction()
                transaction.add(ConventionFragment(),ConventionFragment::class.java.simpleName)
                transaction.commitAllowingStateLoss()

            }

            "Fundraiser Events" -> {
                val transaction = childFragmentManager.beginTransaction()
                transaction.add(FundraiserFragment(),FundraiserFragment::class.java.simpleName)
                transaction.commitAllowingStateLoss()

            }

        }


    }


}