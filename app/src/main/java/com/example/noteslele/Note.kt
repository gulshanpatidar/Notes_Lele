package com.example.noteslele

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//annotate it to make it entity
@Entity(tableName = "notes_table")
//passed the parameter for the text and annotated that this will be a column and it's name will be text
class Note(@PrimaryKey(autoGenerate = true)val id: Int, @ColumnInfo(name = "text")val text: String) {
}