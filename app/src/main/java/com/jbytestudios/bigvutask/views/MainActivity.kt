package com.jbytestudios.bigvutask.views

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Menu

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.appcompat.widget.SearchView

import com.jbytestudios.bigvutask.R
import com.jbytestudios.bigvutask.adapters.WorkshopAdapter
import com.jbytestudios.bigvutask.databinding.ActivityMainBinding
import com.jbytestudios.bigvutask.model.Workshop
import com.jbytestudios.bigvutask.model.WorkshopConstants
import com.jbytestudios.bigvutask.network.DataSource
import com.jbytestudios.bigvutask.network.ResponseInterface

import java.util.*

class MainActivity : AppCompatActivity() {

    private val TAG: String = "MainActivity"
    private lateinit var workshopListCopy: MutableList<Workshop>
    private lateinit var workshopListNew: MutableList<Workshop>
    private lateinit var binding: ActivityMainBinding
    private lateinit var linearLayoutManager: LinearLayoutManager

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

        linearLayoutManager = LinearLayoutManager(this)
        binding.workshopCoachesList.layoutManager = linearLayoutManager

        workshopListCopy = arrayListOf()
        workshopListNew = arrayListOf()

        fetchData()

        observeLiveData()
    }

    private fun fetchData(){
        //test
        //Fetch workshops data
        DataSource.fetchData(object: ResponseInterface {
            override fun onResponse(workshopList: MutableList<Workshop>) {
                workshopListCopy.addAll(workshopList)
                workshopListNew.addAll(workshopList)
                val workshopAdapter = WorkshopAdapter(applicationContext, workshopListCopy.sortedBy { it.name })
                binding.workshopCoachesList.adapter = workshopAdapter
                val availableWorkshops = "${resources.getString(R.string.amount_workshops_template_one)} " +
                        "${workshopListCopy.size} ${resources.getString(R.string.amount_workshops_template_two)}"
                binding.workshopCoachesHeader.headerDynamicText.text = availableWorkshops
                workshopAdapter.onItemClick = { workshop ->
                    val intent = Intent(applicationContext, WorkshopDetailsActivity()::class.java)

                    intent.putExtra(WorkshopConstants.IMAGE_URL, workshop.imageUrl)
                    intent.putExtra(WorkshopConstants.VIDEO_URL, workshop.video)
                    intent.putExtra(WorkshopConstants.NAME, workshop.name)
                    intent.putExtra(WorkshopConstants.DESCRIPTION, workshop.description)
                    intent.putExtra(WorkshopConstants.TEXT, workshop.text)

                    startActivity(intent)
                }
            }

            override fun onFailure(errorMessage: String) {

            }
        })
    }

    private fun observeLiveData() {

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        val item = menu?.findItem(R.id.action_search)
        val searchView = item?.actionView as SearchView
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }

            @SuppressLint("NotifyDataSetChanged")
            override fun onQueryTextChange(newText: String?): Boolean {
                val handler = Handler(Looper.getMainLooper())
                handler.postDelayed({

                    val searchText = newText!!.lowercase(Locale.getDefault())
                    workshopListCopy.clear()
                    //works until here
                    if (searchText.isNotEmpty()){
                        workshopListNew.forEach {
                            if (it.description.lowercase(Locale.getDefault()).contains(searchText)){
                                workshopListCopy.add(it)
                            }
                        }
                        binding.workshopCoachesList.adapter!!.notifyDataSetChanged()
                    } else {
                        workshopListCopy.clear()
                        workshopListCopy.addAll(workshopListNew)
                        binding.workshopCoachesList.adapter!!.notifyDataSetChanged()
                    }

                    val workshopAdapter = WorkshopAdapter(applicationContext, workshopListCopy.sortedBy { it.name })
                    binding.workshopCoachesList.adapter = workshopAdapter
                }, 300)
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)
    }

}