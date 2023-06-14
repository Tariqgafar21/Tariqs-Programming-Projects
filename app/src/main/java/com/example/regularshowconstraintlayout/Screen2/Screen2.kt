package com.example.regularshowconstraintlayout.Screen2

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.regularshowconstraintlayout.R
import com.example.regularshowconstraintlayout.TabAdapter
import com.example.regularshowconstraintlayout.databinding.Screen2Binding
import java.util.ArrayList

class Screen2 : AppCompatActivity() {
    private val binding by lazy {
        DataBindingUtil.setContentView<Screen2Binding>(this, R.layout.screen2)
    }
    lateinit var recycle: RecyclerView

    var tabNameList = ArrayList<String>()

    //var imageList = ArrayList<Integer>()
    lateinit var adapter: TabAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




        binding.Recycle.layoutManager = LinearLayoutManager(this@Screen2)
        tabNameList.add("Our Mission")
        tabNameList.add("General Body Information")
        tabNameList.add("Convention Information")
        tabNameList.add("Fundraiser Events")
        tabNameList.add("Members of the Month")
        tabNameList.add("Meet The Eboard!")
        tabNameList.add("Workshops")
        tabNameList.add("Member dues/information")
        tabNameList.add("Social media")

        adapter = TabAdapter(tabNameList, this@Screen2)
        binding.Recycle.adapter = adapter


    }
}



