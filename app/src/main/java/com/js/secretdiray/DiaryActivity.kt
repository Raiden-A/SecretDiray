package com.js.secretdiray

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.core.widget.addTextChangedListener
import com.js.secretdiray.databinding.ActivityDiaryBinding

class DiaryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDiaryBinding
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDiaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initDetaiEditText()

    }

    private fun initDetaiEditText() {
        val detail = MyApp.prefs.getString("detail", "")
        binding.diaryEditText.setText(detail)

        val runnable = Runnable {
            MyApp.prefs.setString("detail", binding.diaryEditText.text.toString())
        }
        binding.diaryEditText.addTextChangedListener {
            Log.d("DiarYActivity", "text Changed :: $it")
            handler.removeCallbacks(runnable)
            handler.postDelayed(runnable, 500)
        }

    }

}