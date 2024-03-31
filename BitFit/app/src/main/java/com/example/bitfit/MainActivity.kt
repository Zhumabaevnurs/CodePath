package com.example.bitfit

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val newFoodActivityRequestCode = 1
    private lateinit var itemViewModel: ItemViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.rvFood)
        val adapter = FoodAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        itemViewModel = ViewModelProvider(this).get(ItemViewModel::class.java)

        itemViewModel.allItems.observe(this, Observer { food ->
            food?.let { adapter.setFood(it) }
        })

        findViewById<Button>(R.id.btnAdd).setOnClickListener{
            val intent = Intent(this, AddFoodActivity::class.java)
            startActivityForResult(intent, newFoodActivityRequestCode)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)

        if (requestCode == newFoodActivityRequestCode && resultCode == Activity.RESULT_OK) {
            intentData?.let { data ->
                val food = FoodItem(0,data.getStringExtra(AddFoodActivity.EXTRA_REPLY), data.getStringExtra(AddFoodActivity.EXTRA_CAL).toString().toInt())
                itemViewModel.insert(food)
            }
        } else {
            Toast.makeText(
                applicationContext,
                "Not saved",
                Toast.LENGTH_LONG
            ).show()
        }
    }



}