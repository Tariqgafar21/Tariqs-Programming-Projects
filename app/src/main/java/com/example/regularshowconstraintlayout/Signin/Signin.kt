package com.example.regularshowconstraintlayout.Signin

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.DataBindingUtil
import com.example.regularshowconstraintlayout.R
import com.example.regularshowconstraintlayout.Screen2.MainActivity
import com.example.regularshowconstraintlayout.databinding.HomescreenBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        DataBindingUtil.setContentView<HomescreenBinding>(this, R.layout.homescreen)
    }

    fun nextClick() {
        startActivity(Intent(this@MainActivity, MainActivity::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.login.setOnClickListener {
            //binding.email.visibility = View.VISIBLE
            //binding.password.visibility = View.VISIBLE
            //binding.E2.visibility = View.VISIBLE
            //binding.P2.visibility = View.VISIBLE
        }

        binding.password.doAfterTextChanged {
            binding.Next.isEnabled = (it?.toString()?.length ?: 0) >= 5

        }

        binding.Next.setOnClickListener {
            nextClick()
        }

    }


}









