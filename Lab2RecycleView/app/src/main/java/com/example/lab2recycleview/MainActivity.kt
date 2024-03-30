package com.example.lab2recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

lateinit var emails: List<Email>

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Lookup the RecyclerView in activity layout
        val emailsRv = findViewById<RecyclerView>(R.id.emailsRv)
        // Fetch the list of emails
        emails = EmailFetcher.getEmails() //Call getEmails() from the EmailFetcher class and save the results to emails
        // Create adapter passing in the list of emails
        val adapter = EmailAdapter(emails) //Create an instance of EmailAdapter and pass in the list of emails
        // Attach the adapter to the RecyclerView to populate items
        emailsRv.adapter = adapter  ///Attach the adapter to recycler view by setting its' "adapter" field:
        // Set layout manager to position the items
        //Set the layout manager for the RecyclerView to tell the RecyclerView how to position the items.
        // LinearLayoutManager tells the RecyclerView to layout the items on top of each other:
        emailsRv.layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.loadMoreBtn).setOnClickListener {
            // Fetch next 5 emails
            val newEmails = EmailFetcher.getNext5Emails()
            // Add new emails to existing list of emails
            (emails as MutableList<Email>).addAll(newEmails)
            // Notify the adapter there's new emails so the RecyclerView layout is updated
            adapter.notifyDataSetChanged()
        }
    }
}