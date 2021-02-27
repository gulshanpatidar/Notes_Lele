package com.example.noteslele

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.noteslele.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //create the variable for data binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //set the data binding
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
    }
}