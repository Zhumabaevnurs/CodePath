package com.example.wishlist


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private val mutable_list= mutableListOf<WishlistItem>()
private lateinit var list_wish : RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Lookup the RecyclerView in activity layout
        val list_wish = findViewById<RecyclerView>(R.id.recyclerView)
        val wishAdapter= WishlistAdapter(mutable_list)

        // Attach the adapter to the RecyclerView to populate items
        list_wish.adapter= wishAdapter
        // Set layout manager to position the items
        list_wish.layoutManager=LinearLayoutManager(this)

        // Lookup the name,price and url ids in activity layout
        val wishItemname = findViewById<EditText>(R.id.name)
        val wishUrlsearch = findViewById<EditText>(R.id.url)
        val wishPricenum = findViewById<EditText>(R.id.price)

        findViewById<Button>(R.id.button).setOnClickListener {
            var item : WishlistItem = WishlistItem(wishItemname.text.toString(), wishUrlsearch.text.toString(), wishPricenum.text.toString().toDouble())
            mutable_list.add(item)
            findViewById<EditText>(R.id.price).text.clear()
            findViewById<EditText>(R.id.name).text.clear()
            findViewById<EditText>(R.id.url).text.clear()
            wishAdapter.notifyDataSetChanged()
        }
    }
}