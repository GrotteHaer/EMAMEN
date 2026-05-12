package com.example.counterapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {

    private lateinit var counterTextView: TextView
    private lateinit var plusButton: Button
    private lateinit var minusButton: Button

    private var counter = 0
    private val minValue = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        counterTextView = findViewById(R.id.counterTextView)
        plusButton = findViewById(R.id.plusButton)
        minusButton = findViewById(R.id.minusButton)

        updateCounterDisplay()

        plusButton.setOnClickListener {
            counter++
            updateCounterDisplay()
        }

        minusButton.setOnClickListener {
            if (counter > minValue) {
                counter--
                updateCounterDisplay()
            }
        }
    }

    private fun updateCounterDisplay() {
        counterTextView.text = counter.toString()
        // Дополнительно: можно менять доступность кнопки "минус"
        minusButton.isEnabled = counter > minValue
    }
}