package com.js.secretdiray

import android.app.Application

class MyApp : Application() {
    companion object{
        lateinit var prefs : PrefUtils
    }

    override fun onCreate() {
        prefs = PrefUtils(applicationContext)
        super.onCreate()
    }
}