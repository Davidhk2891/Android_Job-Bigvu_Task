package com.jbytestudios.bigvutask.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jbytestudios.bigvutask.R
import com.jbytestudios.bigvutask.utils.BIGVULog

class MainActivity : AppCompatActivity() {

    val TAG: String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        BIGVULog.i(TAG, "onCreate", "Test")

    }

}