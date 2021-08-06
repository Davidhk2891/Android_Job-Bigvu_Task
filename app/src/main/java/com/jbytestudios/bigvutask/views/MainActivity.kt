package com.jbytestudios.bigvutask.views

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ConcatAdapter
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.jbytestudios.bigvutask.adapters.HeaderAdapter
import com.jbytestudios.bigvutask.adapters.WorkshopAdapter
import com.jbytestudios.bigvutask.databinding.ActivityMainBinding
import com.jbytestudios.bigvutask.network.DataSource

const val FLOWER_ID = "flower_id"

class MainActivity : AppCompatActivity() {

    private val TAG: String = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    lateinit var linearLayoutManager: LinearLayoutManager

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
        binding.workshopCoachesList.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        binding.workshopCoachesList.layoutManager = linearLayoutManager

        val headerAdapter = HeaderAdapter()
        val workshopAdapter = WorkshopAdapter(this, )
        val concatAdapter = ConcatAdapter(headerAdapter, workshopAdapter)

        linearLayoutManager = LinearLayoutManager(this)
        binding.workshopCoachesList.layoutManager = linearLayoutManager
        binding.workshopCoachesList.adapter = concatAdapter

        //test
        DataSource.fetchData()

        observeLiveData()
    }

    private fun observeLiveData() {

    }

}