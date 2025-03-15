package com.example.Godovih_01_03

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.Godovih_01_03.R


class CalculationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculation)

        val apartmentSpinner: Spinner = findViewById(R.id.typeSpinner)
        val areaInput: EditText = findViewById(R.id.editTextArea)
        val calculateButton: Button = findViewById(R.id.buttonCalculate)

        val apartmentTypes = arrayOf("1-комнатная", "2-комнатная", "3-комнатная", "Студия")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, apartmentTypes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        apartmentSpinner.adapter = adapter

        calculateButton.setOnClickListener {
            val selectedApartment = apartmentSpinner.selectedItem.toString()
            val area = areaInput.text.toString().toIntOrNull()

            if (area != null) {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("apartment", selectedApartment)
                intent.putExtra("area", area)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Введите количество метров", Toast.LENGTH_SHORT).show()
            }
        }
    }
}