package com.example.regularshowconstraintlayout

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import androidx.databinding.DataBindingUtil
import com.example.regularshowconstraintlayout.Screen2.Screen2
import com.example.regularshowconstraintlayout.databinding.HomescreenBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        DataBindingUtil.setContentView<HomescreenBinding>(this, R.layout.homescreen)
    }

    fun nextClick() {
        startActivity(Intent(this@MainActivity, Screen2::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.login.setOnClickListener {
            binding.email.visibility = View.VISIBLE
            binding.password.visibility = View.VISIBLE
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

    fun showALertDialog() {
        val alert = AlertDialog.Builder(this@MainActivity)

        alert.setTitle("Confirm").setMessage("Do you confirm these changes?")
            .setIcon(R.drawable.warning).setCancelable(false)
            .setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, which ->
                dialogInterface.cancel()
            })
            .setPositiveButton("Yes", DialogInterface.OnClickListener { dialogInterface, which ->
                // binding.Next.text = "Alert Dialog"
            })

        alert.create().show()
    }

}









