package com.example.plantixchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.plantixchallenge.adapter.DataAdapter
import com.example.plantixchallenge.vmodel.ViewModel1

class MainActivity : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val vModel = ViewModel1()

        vModel.getDataModelVM().observe(this, Observer {
            Log.d("itVal", it.toString())
            recyclerView = findViewById(R.id.recyclerView)
            recyclerView?.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            val adapter = DataAdapter(it, this)
            recyclerView?.adapter = adapter
        })


    }
}