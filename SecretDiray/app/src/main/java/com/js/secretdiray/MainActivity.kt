package com.js.secretdiray

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.js.secretdiray.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var changePasswordMode = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initNumberPicker()
        initOpenBUtton()
        initChangePasswordButton()

    }

    private fun initNumberPicker() {

        binding.firstNumPicker.apply {
            minValue = 0
            maxValue = 9
        }

        binding.secondNumPicker.apply {
            minValue = 0
            maxValue = 9
        }

        binding.thirdNumberPicker.apply {
            minValue = 0
            maxValue = 9
        }
    }

    private fun initOpenBUtton() {
        binding.openButton.setOnClickListener {
            if (changePasswordMode) {
                Toast.makeText(
                    this,
                    "비밀번호 변경 모드입니다.",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            val password = "${binding.firstNumPicker.value}" +
                    "${binding.secondNumPicker.value}"
            "${binding.thirdNumberPicker.value}"

            if (password ==
                MyApp.prefs.getString("password", "000")) {
                startActivity(
                    Intent(this, DiaryActivity::class.java)
                )
            } else {
                showErrorPopup()
            }

        }

    }

    private fun showErrorPopup() {
        AlertDialog.Builder(this)
            .setTitle("실패")
            .setMessage("비밀번호가 잘못되었습니다.")
            .setPositiveButton("확인") { _, _ -> }
            .create()
            .show()
    }

    private fun initChangePasswordButton() {

    }
}