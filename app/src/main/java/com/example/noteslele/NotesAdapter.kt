package com.example.noteslele

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//this adapter class is used to set the data to the views
class NotesAdapter(private val context: Context, private val listener: INotesRVAdapter): RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    //allNotes variable is used to store all the notes
    private val allNotes = ArrayList<Note>()

    //this is an inner class which will act as viewHolder for our adapter and it has two views, one for the text and other one is for delete button imageView
    inner class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val textView: TextView = itemView.findViewById(R.id.text)
        val deleteButton: ImageView = itemView.findViewById(R.id.deleteButton)
    }

    //this method in the adapter creates the viewHolder and returns it.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        //viewHolder is being created here
        val viewHolder = NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.item_note,parent,false))
        //adding the click listener to the delete button with the help of viewHolder we have created in  the above step
        viewHolder.deleteButton.setOnClickListener{
            //calling the interface method from here passing the corresponding note which has to be deleted, and here listener is the instance of that interface and we have taken it in our constructor as a argument.
            listener.onItemClicked(allNotes[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    //this method here will bind the views views
    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        //taking the current note with the help of position variable and allNotes
        val currentNote = allNotes[position]
        //setting the text to use the current note
        holder.textView.text = currentNote.text
    }

    //this simply returns the number of notes in this particular case
    override fun getItemCount(): Int {
        return allNotes.size
    }
}

//this is the interface we have used to handle the click listener and we have implemented this in out main activity and defined it's full behaviour and then...
interface INotesRVAdapter{
    fun onItemClicked(note: Note)
}