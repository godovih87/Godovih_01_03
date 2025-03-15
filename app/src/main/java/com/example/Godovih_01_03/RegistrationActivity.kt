package com.example.Godovih_01_03

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.Godovih_01_03.R

class RegistrationActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE)

        val loginButton: Button = findViewById(R.id.buttonLogin)
        val loginInput: EditText = findViewById(R.id.editTextLogin)
        val passwordInput: EditText = findViewById(R.id.editTextPassword)

        loginButton.setOnClickListener {
            val login = loginInput.text.toString()
            val password = passwordInput.text.toString()

            if (login.isEmpty() || password.isEmpty()) {
                AlertDialog.Builder(this)
                    .setTitle("Ошибка")
                    .setMessage("Введите логин и пароль")
                    .setPositiveButton("OK", null)
                    .show()
            } else {
                // Проверка сохраненных данных (при последующих входах)
                if (sharedPreferences.contains("login") && sharedPreferences.contains("password")) {
                    if (login == sharedPreferences.getString("login", "") &&
                        password == sharedPreferences.getString("password", "")
                    ) {
                        startActivity(Intent(this, CalculationActivity::class.java))
                    } else {
                        Toast.makeText(this, "Неверный логин или пароль", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    // Сохранение данных при первом входе
                    with(sharedPreferences.edit()) {
                        putString("login", login)
                        putString("password", password)
                        apply()
                    }
                    startActivity(Intent(this, CalculationActivity::class.java))
                }
            }
        }
    }
}