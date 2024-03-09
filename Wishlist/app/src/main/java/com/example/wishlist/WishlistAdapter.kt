package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


//Connect the data and the layout
//Uses the Email data class to populate the email_item layout
class  WishlistAdapter(private val items: MutableList<WishlistItem>) : RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //class to provide a reference to the type of views that you are using.

        // Your holder should contain a member variable for any view that will be set as you render
        // a row
        val itemEditText: TextView
        val urlEditText: TextView
        val priceEditText: TextView

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            itemEditText = itemView.findViewById(R.id.wishName)
            urlEditText=itemView.findViewById(R.id.wishUrl)
            priceEditText=itemView.findViewById(R.id.wishPrice)
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context=parent.context
        val inflater= LayoutInflater.from(context)
        // Inflate the custom layout
        // Tells to adapter which layout we are going to use
        val contactView=inflater.inflate(R.layout.wishlist_item, parent, false)

        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=items[position]
        holder.itemEditText.text= item.item
        holder.urlEditText.text= item._item_url.toString()
        holder.priceEditText.text=item.price.toString()

    }

    //implement getItemCount() by returning the number of items in the list of items:
    override fun getItemCount(): Int {
        return items.size
    }
}