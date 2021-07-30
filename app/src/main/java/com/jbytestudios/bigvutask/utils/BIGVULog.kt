package com.jbytestudios.bigvutask.utils

import android.util.Log

//Logger class
object BIGVULog {

    private const val APPLICATION_LOG_TAG = "BIGVULOG"

    fun v(classTag: String, methodTag: String, message: String = "v Log called"){
        val logMessage = "[ $classTag :: $methodTag ] -> $message"
        Log.v(APPLICATION_LOG_TAG, logMessage)
    }

    fun i(classTag: String, methodTag: String, message: String = "i Log called"){
        val logMessage = "[ $classTag :: $methodTag ] -> $message"
        Log.i(APPLICATION_LOG_TAG, logMessage)
    }

    fun e(classTag: String, methodTag: String, message: String = "e Log called"){
        val logMessage = "[ $classTag :: $methodTag ] -> $message"
        Log.e(APPLICATION_LOG_TAG, logMessage)
    }

}