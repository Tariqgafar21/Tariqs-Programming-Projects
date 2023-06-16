package com.example.regularshowconstraintlayout.Screen2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.regularshowconstraintlayout.R
import com.example.regularshowconstraintlayout.databinding.Screen2Binding
import com.example.regularshowconstraintlayout.optionlist.OptionListFragment
import java.util.OptionalInt

class Screen2Activity : AppCompatActivity() {
    private val binding by lazy {
        DataBindingUtil.setContentView<Screen2Binding>(this, R.layout.screen2)
    }

    private var isFragmentVisible: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction().apply {
        add(binding.fragmentContainer.id,OptionListFragment(),OptionListFragment::class.java.simpleName)
            commit()
        }

    }

}


/* override fun onBackPressed() {
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

 */














