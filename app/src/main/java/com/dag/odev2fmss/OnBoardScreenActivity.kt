package com.dag.odev2fmss

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.dag.odev2fmss.databinding.ActivityOnBoardScreenBinding

class OnBoardScreenActivity : AppCompatActivity() {

    private lateinit var onBoardDataBinding : ActivityOnBoardScreenBinding
    private lateinit var navigationRoute : Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_board_screen)

      onBoardDataBinding = DataBindingUtil.setContentView(this,R.layout.activity_on_board_screen)

      onBoardDataBinding.joinNowButton.setOnClickListener{
          // navigationRoute use only this function
          navigationRoute = Intent(this,LoginScreenActivity :: class.java)
          startActivity(navigationRoute)
      }
    }
}