package com.dag.odev2fmss

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.DataBindingUtil
import com.dag.odev2fmss.databinding.ActivityLoginScreenBinding


class LoginScreenActivity : AppCompatActivity() {

    private lateinit var loginDataBinding : ActivityLoginScreenBinding
    private lateinit var navigationRoute : Intent
    private lateinit var sharedPreferences : SharedPreferences

    private var registeredUsername : String = "nuri"
    private var registeredPassword : String = "ulgen0707"

    private var userName : String? = null
    private var password : String? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        loginDataBinding = DataBindingUtil.setContentView(this@LoginScreenActivity,R.layout.activity_login_screen)

        loginDataBinding.backButton.setOnClickListener{
            finish() // return to previous page function
        }

        // Shared Preferences
        sharedPreferences = this.getSharedPreferences("com.nuriulgen.sharedpreferences",Context.MODE_PRIVATE)

        userName = sharedPreferences.getString("getUserName","")
        password = sharedPreferences.getString("getPassword","")

        loginDataBinding.textButton.setOnClickListener{
            // Next page function
            navigationRoute = Intent(this@LoginScreenActivity,SignUpScreenActivity :: class.java)
            startActivity(navigationRoute)
        }

        loginDataBinding.loginButton.setOnClickListener {
             userName = loginDataBinding.userNameID.text.toString()
             password = loginDataBinding.passwordID.text.toString()

            if(userName == "" || password == "" ){
                // Checking the null status of inputs
                Toast.makeText(this@LoginScreenActivity,"Username or Password cannot be empty!", Toast.LENGTH_SHORT).show()
            }else if(registeredUsername != userName || registeredPassword != password){
                //Checking the registered user's information
                Toast.makeText(this@LoginScreenActivity,"Your username or password is incorrect", Toast.LENGTH_SHORT).show()
            }
            else{
                // Save data to phone memory
                sharedPreferences.edit().putString("getUserName",userName).apply()
                sharedPreferences.edit().putString("getPassword",password).apply()
            }
        }

        fun EditText.validate(message: String, validator: (String) -> Boolean) {
            this.doAfterTextChanged {
                this.error = if (validator(it.toString())) null else message
            }
            this.error = if (validator(this.text.toString())) null else message
        }
    }
}