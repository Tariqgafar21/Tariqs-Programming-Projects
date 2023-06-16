package com.example.regularshowconstraintlayout.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.regularshowconstraintlayout.TabAdapter
import com.example.regularshowconstraintlayout.ViewHolderClickListener
import com.example.regularshowconstraintlayout.databinding.FragmentListBinding
import java.util.ArrayList

class ListFragment(private val name: String) : Fragment() {


    //I normally hate lateinit, but it's okay for this
    private lateinit var binding: FragmentListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return FragmentListBinding.inflate(inflater, container, false).apply {
            //run this code inside apply before returning
            binding = this
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textview.text = name

    }
}