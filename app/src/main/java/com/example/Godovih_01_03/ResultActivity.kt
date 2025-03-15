package com.example.Godovih_01_03

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.Godovih_01_03.R


class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val resultTextView: TextView = findViewById(R.id.textViewResult)
        val registerButton: Button = findViewById(R.id.buttonRegister)

        val apartment = intent.getStringExtra("apartment")
        val area = intent.getIntExtra("area", 0)

        val pricePerMeter = 1.4 // стоимость метра

        var calculatedPrice = 0.0

        when (apartment) {
            "1-комнатная" -> calculatedPrice = pricePerMeter * area
            "2-комнатная" -> calculatedPrice = pricePerMeter * area
            "3-комнатная" -> calculatedPrice = pricePerMeter * area * 0.8
            "Студия" -> calculatedPrice = pricePerMeter * area
        }

        resultTextView.text = "Стоимость: ${String.format("%.2f", calculatedPrice)} тыс.руб."

        registerButton.setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))
        }
    }
}