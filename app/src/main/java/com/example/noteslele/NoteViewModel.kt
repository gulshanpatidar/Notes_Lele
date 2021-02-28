package com.example.noteslele

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    //variable of NoteRepository, and it is initialized in the init block of the class
    private val repository: NoteRepository
    //variable for all the notes and they are initialized in the init block
    val allNotes: LiveData<List<Note>>

    init {
        //create an instance of the dao so that we can pass it to constructor of the NoteDatabase and create and instance of the NoteRepository
        val dao = NoteDatabase.getDatabase(application).getNoteDao()
        //create instance of the repository with the help of dao
        repository = NoteRepository(dao)
        //get the notes from the repository
        allNotes = repository.allNotes
    }

    //this method is used with the coroutineScope so that suspend methods can be called and that also in the background thread
    //also Dispatchers.IO is telling that we are just performing an simple i/o operation
    fun deleteNote(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        //it is using delete method of repository to delete the note
        repository.delete(note)
    }

    //same it is using coroutines to communicate with the suspend function
    fun insertNote(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(note)
    }
}