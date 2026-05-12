# Экзамен

## Беланов Ростислав
## Вариант 2

### Вот мой вариант
Создайте экран с текстом-счётчиком (начальное значение 0) и двумя кнопками: «+» и «−». 
При нажатии на «+» значение увеличивается на 1, при нажатии на «−» — уменьшается на 1. Минимальное значение — 0 (нельзя уйти в минус).
<p>
### У меня эмулятор не работает(((
### MainActivity.kt:
```kotlin
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
```
### acivity_main.xml:
```kotlin
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center"
    android:padding="16dp">

    <TextView
        android:id="@+id/counterTextView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="0"
        android:textSize="64sp"
        android:textStyle="bold"
        android:layout_marginBottom="32dp" />

    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <Button
            android:id="@+id/minusButton"
            android:layout_width="80dp"
            android:layout_height="80dp"
            android:text="-"
            android:textSize="32sp"
            android:layout_marginEnd="32dp" />

        <Button
            android:id="@+id/plusButton"
            android:layout_width="80dp"
            android:layout_height="80dp"
            android:text="+"
            android:textSize="32sp" />

    </LinearLayout>

</LinearLayout>
```