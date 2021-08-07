package com.jbytestudios.bigvutask.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jbytestudios.bigvutask.databinding.ActivityWorkshopDetailsBinding
import com.jbytestudios.bigvutask.model.WorkshopConstants
import com.jbytestudios.bigvutask.network.media.ImageManager
import com.jbytestudios.bigvutask.network.media.VideoManager

class WorkshopDetailsActivity : AppCompatActivity() {

    private val TAG = "WorkshopDetailsActivity"
    private lateinit var binding: ActivityWorkshopDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initBinding()
        getAndLoadData()

    }

    private fun initBinding(){
        val actionBar = supportActionBar
        actionBar!!.title = "Workshop Details"
        actionBar.setDisplayHomeAsUpEnabled(true)
        binding = ActivityWorkshopDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun getAndLoadData(){
        val bundle: Bundle? = intent.extras
        if (bundle != null) {
            val name = bundle.getString(WorkshopConstants.NAME)
            val text = bundle.getString(WorkshopConstants.TEXT)
            val description = bundle.getString(WorkshopConstants.DESCRIPTION)
            val image = bundle.getString(WorkshopConstants.IMAGE_URL)
            val video = bundle.getString(WorkshopConstants.VIDEO_URL)

            binding.workshopDetailsInfoContainer.workshopDetsItemAuthor.text = name
            binding.workshopDetailsInfoContainer.workshopDetsItemDesc.text = description
            binding.workshopDetailsInfoContainer.workshopDetsItemText.text = text
            ImageManager.loadRoundedImage(image, binding.workshopDetailsInfoContainer.workshopDetsItemImageView)
            video?.let { VideoManager.loadVideo(this, it, binding.workshopDetailsVideoView) }
        }
    }

}