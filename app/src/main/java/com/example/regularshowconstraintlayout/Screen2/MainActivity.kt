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
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.regularshowconstraintlayout.Convention.ConventionFragment
import com.example.regularshowconstraintlayout.Fundraiser.FundraiserFragment
import com.example.regularshowconstraintlayout.Mission.MissionFragment
import com.example.regularshowconstraintlayout.R
import com.example.regularshowconstraintlayout.TabAdapter
import com.example.regularshowconstraintlayout.ViewHolderClickListener
import com.example.regularshowconstraintlayout.databinding.Screen2Binding
import com.example.regularshowconstraintlayout.list.ListFragment
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        DataBindingUtil.setContentView<Screen2Binding>(this, R.layout.screen2)
    }
    lateinit var recycle: RecyclerView

    var tabNameList = ArrayList<String>()

    //var imageList = ArrayList<Integer>()
    lateinit var adapter: TabAdapter
    private var isFragmentVisible: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding.Recycle.layoutManager = LinearLayoutManager(this)
        tabNameList.add("Our Mission")
        tabNameList.add("General Body Information")
        tabNameList.add("Convention Information")
        tabNameList.add("Fundraiser Events")
        tabNameList.add("Members of the Month")
        tabNameList.add("Meet The Eboard!")
        tabNameList.add("Workshops")
        tabNameList.add("Member dues/information")
        tabNameList.add("Social media")
        val listener = object : ViewHolderClickListener {
            override fun onVHClicked(name: String) {
                //if binding.fragmentContainer.childCount > 0
                //return
                Toast.makeText(this@MainActivity, name, Toast.LENGTH_SHORT).show()
                gotoNewFragment(name)
            }

        }


        adapter = TabAdapter(tabNameList, this, listener)
        binding.Recycle.adapter = adapter
        /*binding.Recycle.setOnClickListener {
            if (isFragmentVisible) {
                binding.Recycle.visibility = View.INVISIBLE
            }
        }

         */
        binding.Recycle.setOnClickListener {
            if (!isFragmentVisible) {
                // Perform the click action only if no fragment is visible
                val position = binding.Recycle.getChildAdapterPosition(it)
                if (position != RecyclerView.NO_POSITION) {
                    val clickedItem = tabNameList[position]
                    // Handle the click event
                    Toast.makeText(this@MainActivity, clickedItem, Toast.LENGTH_SHORT).show()
                    gotoNewFragment(clickedItem)
                }
            }
        }


    }


    private fun gotoNewFragment(name: String) {
        when (name) {
            "Our Mission" -> {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(binding.fragmentContainer.id, MissionFragment())
                transaction.commitAllowingStateLoss()

            }

            "General Body Information" -> {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(binding.fragmentContainer.id, ListFragment(name))
                transaction.commitAllowingStateLoss()
            }

            "Convention Information" -> {
                val fragmentManager: FragmentManager = supportFragmentManager
                val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
                val convFragment = ConventionFragment()
                fragmentTransaction.add(R.id.fragment_container, convFragment)
                fragmentTransaction.commit()

            }

            "Fundraiser Events" -> {
                val fragmentManager: FragmentManager = supportFragmentManager
                val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
                val fundFrag = FundraiserFragment()
                fragmentTransaction.add(R.id.fragment_container, fundFrag)
                fragmentTransaction.commit()

            }

        }

        binding.Recycle.visibility = View.GONE
        binding.fragmentContainer.visibility = View.VISIBLE
        }

    override fun onResume() {
        super.onResume()
        isFragmentVisible = true
    }

    override fun onPause() {
        super.onPause()
        isFragmentVisible = false
    }



    override fun onBackPressed() {
        super.onBackPressed()
    supportFragmentManager.popBackStack()

    val fragment = supportFragmentManager.findFragmentByTag("OurMission")
    if (fragment != null) {
        //currently viewing recyclerview
        super.onBackPressed()
    } else {
        //go back to recyclerview
    }



    supportFragmentManager.popBackStackImmediate()



        /*val fragment = supportFragmentManager.findFragmentById(R.id.fragment_container)

        if (fragment != null && fragment.isVisible) {
            // Currently viewing the RecyclerView fragment
            super.onBackPressed()
        } else {
            // Go back to the RecyclerView fragment
            supportFragmentManager.popBackStackImmediate()
        }


         */

    }
}









