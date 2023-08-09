package com.example.regularshowconstraintlayout.Screen2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.regularshowconstraintlayout.Convention.ConventionFragment
import com.example.regularshowconstraintlayout.GBM.GBM
import com.example.regularshowconstraintlayout.MeetTheEboard.Eboard
import com.example.regularshowconstraintlayout.MemberMonth.MembersMonth
import com.example.regularshowconstraintlayout.Mission.MissionFragment
import com.example.regularshowconstraintlayout.R
import com.example.regularshowconstraintlayout.Workshops.Workshops
import com.example.regularshowconstraintlayout.databinding.Screen2Binding
import com.example.regularshowconstraintlayout.optionlist.OptionListFragment

class Screen2Activity : AppCompatActivity() {
    //inflate the layout and bind it to the object
    private val binding by lazy {
        DataBindingUtil.setContentView<Screen2Binding>(this, R.layout.screen2)
    }


    //method is called when the activity is being created
    override fun onCreate(savedInstanceState: Bundle?) {
        //calls onCreate to do any initialization
        super.onCreate(savedInstanceState)
        //fragment transaction is preformed using this
        supportFragmentManager.beginTransaction().apply {
            //adds an instance of OptionListFragment to fragment container
            add(binding.fragmentContainer.id, OptionListFragment())
            //solidiifes changed
            commit()
        }

    }

    fun gotoNewFragment(name: String) {
        when (name) {
            "Our Mission" -> {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.add(
                    binding.fragmentContainer.id,
                    MissionFragment(),
                    MissionFragment::class.java.simpleName
                )
                transaction.addToBackStack(MissionFragment::class.java.simpleName)
                transaction.commitAllowingStateLoss()


            }

            "General Body Information" -> {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.add(binding.fragmentContainer.id, GBM(), GBM::class.java.simpleName)
                transaction.addToBackStack(GBM::class.java.simpleName)
                transaction.commitAllowingStateLoss()

            }

            "Convention Information" -> {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.add(
                    binding.fragmentContainer.id,
                    ConventionFragment(),
                    ConventionFragment::class.java.simpleName
                )
                transaction.addToBackStack(ConventionFragment::class.java.simpleName)
                transaction.commitAllowingStateLoss()


            }

            "Members of the Month" -> {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.add(
                    binding.fragmentContainer.id,
                    MembersMonth(),
                    MembersMonth::class.java.simpleName
                )
                transaction.addToBackStack(MembersMonth::class.java.simpleName)
                transaction.commitAllowingStateLoss()
            }

            "Meet The Eboard!" -> {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.add(
                    binding.fragmentContainer.id,
                    Eboard(),
                    Eboard::class.java.simpleName
                )
                transaction.addToBackStack(Eboard::class.java.simpleName)
                transaction.commitAllowingStateLoss()

            }

            "Professional Development" -> {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.add(
                    binding.fragmentContainer.id,
                    Workshops(),
                    Workshops::class.java.simpleName
                )
                transaction.addToBackStack(Workshops::class.java.simpleName)
                transaction.commitAllowingStateLoss()

            }

        }
    }

}






















