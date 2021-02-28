package com.example.noteslele

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//annotate it to make it entity
@Entity(tableName = "notes_table")
//passed the parameter for the text and annotated that this will be a column and it's name will be text
class Note(@ColumnInfo(name = "text")val text: String) {
    //do no pass it in constructor so that it can be auto generated and you do no have to pass id explicitly each time
    @PrimaryKey(autoGenerate = true)var id = 0
}