package com.dag.odev2fmss

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.dag.odev2fmss.databinding.ActivitySignUpScreenBinding

class SignUpScreenActivity : AppCompatActivity() {

    private lateinit var signUpDataBinding : ActivitySignUpScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_screen)

        signUpDataBinding = DataBindingUtil.setContentView(this,R.layout.activity_sign_up_screen)

        signUpDataBinding.backButton.setOnClickListener{
            finish() // return to previous page function
        }

        signUpDataBinding.signUpButton.setOnClickListener {
         userInfo()
        }
    }
    private fun userInfo (){
     if (signUpDataBinding.emailAddress.text.toString().isNotEmpty() && signUpDataBinding.createUserName.text.toString().isNotEmpty()
         && signUpDataBinding.createPassword.text.toString().isNotEmpty()){

         Toast.makeText(this@SignUpScreenActivity,"Email: ${signUpDataBinding.emailAddress.text}\n" +
                 "Username: ${signUpDataBinding.createUserName.text}\n" +
                 "Password: ${signUpDataBinding.createPassword.text}" +
                 "You have successfully registered"
             ,Toast.LENGTH_LONG).show()
     }else{
         Toast.makeText(this,"Please fill all fields",Toast.LENGTH_LONG).show()
     }
    }
}