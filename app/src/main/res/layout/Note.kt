package layout

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//annotate it to make it entity
@Entity(tableName = "notes_table")
//passed the parameter for the text and annotated that this will be a column and it's name will be text
class Note(@ColumnInfo(name = "text")val text: String) {
    //annotated that this will be also a column and it is primary key and turned the auto generate on so that we don't have to pass the id each time. and that's why it is not passed into the constructor instead it is defined inside the class itself.
    @PrimaryKey(autoGenerate = true)val id = 0
}