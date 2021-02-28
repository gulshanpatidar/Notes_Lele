package com.example.noteslele

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteslele.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), INotesRVAdapter {

    //create the variable for data binding
    private lateinit var binding: ActivityMainBinding
    //variable for viewModel
    private lateinit var viewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //set the data binding
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        //set the layout manager
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = NotesAdapter(this,this)
        binding.recyclerView.adapter = adapter

        //create an instance of the viewModel
        viewModel = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewModel::class.java)
        //add the lifecycle observer for the all Notes such that when the data changes, it can perform the appropriate actions
        viewModel.allNotes.observe(this, Observer {list ->
            //it is just a null check
            list?.let {
                //calling this method so that all the notes can be changed on the screen because notes in the database have changed
                adapter.updateNotes(it)
            }
        })

    }

    //we have implemented the interface which we have declared in the adapter file for click handle and therefor we have defined this method here
    override fun onItemClicked(note: Note) {
        //call the delete method from the viewModel to delete this particular note on which user has clicked
        viewModel.deleteNote(note)
        //creating a toast message for this
        Toast.makeText(this,"${note.text} Deleted",Toast.LENGTH_LONG).show()
    }

    //this method is called when user click on the submit button
    fun submitNote(view: View) {
        //extracting the text from the editText view
        val noteText = binding.noteInput.text.toString()
        //check if the user entered a text or it is empty
        if (noteText.isNotEmpty()){
            //create the instance of the Note and pass it to the insertNote method to insert the note
            viewModel.insertNote(Note(noteText))
            //create a toast message to notify user
            Toast.makeText(this,"${noteText} Inserted",Toast.LENGTH_LONG).show()
        }
    }
}