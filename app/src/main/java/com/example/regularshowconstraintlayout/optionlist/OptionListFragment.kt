package com.example.regularshowconstraintlayout.optionlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.regularshowconstraintlayout.Convention.ConventionFragment
import com.example.regularshowconstraintlayout.Fundraiser.FundraiserFragment
import com.example.regularshowconstraintlayout.Mission.MissionFragment
import com.example.regularshowconstraintlayout.R
import com.example.regularshowconstraintlayout.Screen2.Screen2Activity
import com.example.regularshowconstraintlayout.TabAdapter
import com.example.regularshowconstraintlayout.ViewHolderClickListener
import com.example.regularshowconstraintlayout.databinding.FragmentOptionListBinding
import com.example.regularshowconstraintlayout.list.ListFragment


class OptionListFragment : Fragment(), ViewHolderClickListener{

private lateinit var tempArrayList: ArrayList<OptionListFragment>
    override fun onCreateView(
        //inflater is the xml responsible for being displayed, container is the parent ViewGroup for the fragments layout, savedInstanceState is a bundle that holds the states for the fragments
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
        //creates an instance for the tabAdapter class, requireContext() is the same as this@activity, but for fragments which is referncing the fragmnet you want to take the data from
        val adapter = TabAdapter(tabNameList, requireContext(), this)
        //sets the created adapter as the adapter for the RecycylerView
        binding.Recycle.adapter = adapter
        //returns the root view of the layout that is going to show the objects
        return binding.root


    }

    override fun onVHClicked(name: String) {
        (activity as? Screen2Activity)?.gotoNewFragment(name)
        //Toast.makeText(requireContext(), name, Toast.LENGTH_SHORT).show()

    }




    }


