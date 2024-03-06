package com.example.a_i_vv_rv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity_VV : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_vv)

        setContentView(R.layout.activity_main_vv_linear)

        setContentView(R.layout.activity_main_vv_constraint)
        Log.d("Println",this.baseContext.toString())
    }
}