package com.example.regularshowconstraintlayout.Signin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.regularshowconstraintlayout.R
import com.example.regularshowconstraintlayout.databinding.SignupBinding

class SignUpActivity : AppCompatActivity() {
    private val binding by lazy {
        DataBindingUtil.setContentView<SignupBinding>(this, R.layout.signup)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding

        binding.confirm.setOnClickListener {
            finish()
        }
    }


}

