package com.example.regularshowconstraintlayout.optionlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.regularshowconstraintlayout.Screen2.Screen2Activity
import com.example.regularshowconstraintlayout.TabAdapter
import com.example.regularshowconstraintlayout.ViewHolderClickListener
import com.example.regularshowconstraintlayout.databinding.FragmentOptionListBinding


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
        tabNameList.add("Members of the Month")
        tabNameList.add("Meet The Eboard!")
        tabNameList.add("Workshops")
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


