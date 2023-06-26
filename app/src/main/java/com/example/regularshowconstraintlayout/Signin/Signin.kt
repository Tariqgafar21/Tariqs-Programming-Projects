package com.example.regularshowconstraintlayout.Signin

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.DataBindingUtil
import com.example.regularshowconstraintlayout.R
import com.example.regularshowconstraintlayout.Screen2.Screen2Activity
import com.example.regularshowconstraintlayout.databinding.SigninBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {
    private val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private val reference: DatabaseReference = database.reference.child("users")

    private val binding by lazy {
        DataBindingUtil.setContentView<SigninBinding>(this, R.layout.signin)
    }

    fun nextClick() {
        startActivity(Intent(this,Screen2Activity::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        binding.textpassword.doAfterTextChanged {
            binding.loginButton.isEnabled = (it?.toString()?.length ?: 0) >= 4

        }




        binding.loginButton.setOnClickListener {
            nextClick()
            val userName: String = binding.username.text.toString()
            val pin : String = binding.textpassword.text.toString()
            reference.child("userName").setValue(userName)
            reference.child("pin").setValue(pin)


        }

    }


}









