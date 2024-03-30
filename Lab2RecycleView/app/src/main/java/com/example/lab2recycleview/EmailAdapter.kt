package com.example.lab2recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


//Connect the data and the layout
//Uses the Email data class to populate the email_item layout
class EmailAdapter(private val emails : List<Email>) : RecyclerView.Adapter<EmailAdapter.ViewHolder>() {
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {  //class to provide a reference to the type of views that you are using.

        // Your holder should contain a member variable for any view that will be set as you render
        // a row
        val senderTextView: TextView
        val titleTextView: TextView
        val summaryTextView: TextView

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            senderTextView = itemView.findViewById(R.id.sender) //sender coming from email_item.xml file
            titleTextView = itemView.findViewById(R.id.title)    //title coming from email_item.xml file
            summaryTextView = itemView.findViewById(R.id.summary) //summary coming from email_item.xml file
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.email_item, parent, false) //   tell to adapter which layout we are gonna use
        // Return a new holder instance
        return ViewHolder(contactView) //
    }

    //implement getItemCount() by returning the number of emails in the list of emails:
    override fun getItemCount(): Int {
        return emails.size
    }

    // Populate data into the item through the holder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) { // we need to populate sender, title, and summary
        // Get the data model based on position
        val email = emails.get(position)
        // Set item views based on views and data model
        holder.senderTextView.text = email.sender
        holder.titleTextView.text = email.title
        holder.summaryTextView.text = email.summary
    }
}