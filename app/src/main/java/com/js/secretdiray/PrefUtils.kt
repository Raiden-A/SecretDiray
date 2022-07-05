package com.js.secretdiray

import android.content.Context
import android.content.SharedPreferences

class PrefUtils(context: Context) {
    private val prefs : SharedPreferences =
        context.getSharedPreferences("password",
            Context.MODE_PRIVATE)

    fun getString(Key: String, defValue : String) : String {
        return prefs.getString(Key, defValue).toString()
    }

    fun setString(Key: String, str : String) {
        prefs.edit().putString(Key, str).apply()
    }
}