package com.cs407.calculator

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val num1Input = findViewById<EditText>(R.id.input1)
        val num2Input = findViewById<EditText>(R.id.input2)

        val add = findViewById<Button>(R.id.addButton)
        val subtract = findViewById<Button>(R.id.subtractButton)
        val multiply = findViewById<Button>(R.id.multiplyButton)
        val divide = findViewById<Button>(R.id.divideButton)

        add.setOnClickListener {
            val num1 = num1Input.text.toString().toDoubleOrNull()
            val num2 = num2Input.text.toString().toDoubleOrNull()
            if (num1 == null || num2 == null) {
                Toast.makeText(this, "Must enter both numbers", Toast.LENGTH_SHORT).show()
            }
            else {
                val calculation = num1 + num2
                Log.i("INFO", "$calculation")

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("EXTRA_NUMBER", calculation)
                startActivity(intent)
            }
        }

        subtract.setOnClickListener {
            val num1 = num1Input.text.toString().toDoubleOrNull()
            val num2 = num2Input.text.toString().toDoubleOrNull()
            if (num1 == null || num2 == null) {
                Toast.makeText(this, "Must enter both numbers", Toast.LENGTH_SHORT).show()
            }
            else {
                val calculation = num1 - num2
                Log.i("INFO", "$calculation")

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("EXTRA_NUMBER", calculation)
                startActivity(intent)
            }
        }

        multiply.setOnClickListener {
            val num1 = num1Input.text.toString().toDoubleOrNull()
            val num2 = num2Input.text.toString().toDoubleOrNull()
            if (num1 == null || num2 == null) {
                Toast.makeText(this, "Must enter both numbers", Toast.LENGTH_SHORT).show()
            }
            else {
                val calculation = num1 * num2
                Log.i("INFO", "$calculation")

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("EXTRA_NUMBER", calculation)
                startActivity(intent)
            }
        }

        divide.setOnClickListener {
            val num1 = num1Input.text.toString().toDoubleOrNull()
            val num2 = num2Input.text.toString().toDoubleOrNull()
            if (num1 == null || num2 == null) {
                Toast.makeText(this, "Must enter both numbers", Toast.LENGTH_SHORT).show()
            }
            else if (num2 == 0.0) {
                Toast.makeText(this, "Can't divide by 0", Toast.LENGTH_SHORT).show()
            }
            else {
                val calculation = num1 / num2
                Log.i("INFO", "$calculation")

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("EXTRA_NUMBER", calculation)
                startActivity(intent)
            }
        }
    }
}