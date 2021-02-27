package com.example.noteslele

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    //variable for all the notes
    val allNotes: LiveData<List<Note>>

    init {
        //create an instance of the dao so that we can pass it to constructor of the NoteDatabase and create and instance of the NoteRepository
        val dao = NoteDatabase.getDatabase(application).getNoteDao()
        //create instance of the repository with the help of dao
        val repository = NoteRepository(dao)
        //get the notes from the repository
        allNotes = repository.allNotes
    }
}