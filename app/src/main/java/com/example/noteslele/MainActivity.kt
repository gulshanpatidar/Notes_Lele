package com.example.noteslele

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.noteslele.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //create the variable for data binding
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //set the data binding
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        //create an instance of the viewModel
        viewModel = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewModel::class.java)
        //add the lifecycle observer for the all Notes such that when the data changes, it can perform the appropriate actions
        viewModel.allNotes.observe(this, Observer {

        })
    }
}