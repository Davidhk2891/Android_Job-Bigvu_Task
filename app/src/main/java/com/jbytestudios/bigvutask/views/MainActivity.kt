package com.jbytestudios.bigvutask.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ConcatAdapter
import android.os.Bundle
import com.jbytestudios.bigvutask.adapters.HeaderAdapter
import com.jbytestudios.bigvutask.adapters.WorkshopAdapter
import com.jbytestudios.bigvutask.databinding.ActivityMainBinding
import com.jbytestudios.bigvutask.model.Workshop

const val FLOWER_ID = "flower_id"

class MainActivity : AppCompatActivity() {

    private val TAG: String = "MainActivity"
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initBinding()
        initElements()
    }

    private fun initBinding(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    private fun initElements(){
        val headerAdapter = HeaderAdapter()
        val workshopAdapter = WorkshopAdapter{ workshop ->  adapterOnClick(workshop)}
        val concatAdapter = ConcatAdapter(headerAdapter, workshopAdapter)

        binding.workshopCoachesList.adapter = concatAdapter

        observeLiveData()
    }

    private fun observeLiveData() {

    }

    private fun adapterOnClick(workshop: Workshop) {
        val intent = Intent(this, WorkshopDetailsActivity()::class.java)
        intent.putExtra(FLOWER_ID, workshop.id)
        startActivity(intent)
    }

}