package com.example.noteslele

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    //onConflict is used to ensure that repetition of data doesn't occur
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    //suspend keyword ensure that this operation will be performed in the background thread to make overall experience of the app smooth
    suspend fun insert(note : Note)


    @Delete
    suspend fun delete(note: Note)

    //this query is used to show all the data present in the notes_table and we putted that into the live data list of notes.
    @Query("SELECT * FROM notes_table ORDER BY id ASC")
    fun getNotes(): LiveData<List<Note>>
}