package com.example.assignment11standroidapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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
        val grade_button = findViewById<Button>(R.id.grade_button)
        grade_button.setOnClickListener {
            val enter_grade = findViewById<EditText>(R.id.enter_grade)
            val input_grade = enter_grade.getText().toString()
            val grade_int = Integer.parseInt(input_grade) //this is our grade in Integer form
        }
    }

    fun getGrade(int: Int) {
        return when (int)
        {

        }
    }
}

//big if for A, B, C, or F
// Small inner if for whether it's + or - or regular letter