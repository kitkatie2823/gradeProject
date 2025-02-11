package com.example.assignment11standroidapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Spinner
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
            val input_grade = enter_grade.text.toString().trim()

            // Check if the input is empty
            if (input_grade.isEmpty()) {
                val gradeDisplay = findViewById<TextView>(R.id.gradeDisplay)
                gradeDisplay.text = "Please enter a valid grade."
                return@setOnClickListener
            }

                val grade_int = input_grade.toInt() // Convert input to integer
                val grade_Letter = getGrade(grade_int) // Determine grade letter
                val gradeDisplay = findViewById<TextView>(R.id.gradeDisplay)

                if (enter_grade != null) { // Check if enter_grade is not null
                    gradeDisplay.text = "You got grade " + grade_Letter
                }
        }

        val findStudent = findViewById<ListView>(R.id.student_listView)
        findStudent.setOnClickListener {
//            val beerColor = findViewById<Spinner>(R.id.beer_color)
//            val color = beerColor.selectedItem
//            val beerList = getBeers(color.toString())
//            val beers = beerList.reduce{ str, item -> str + '\n' + item }
//            val brands = findViewById<TextView>(R.id.brands)
//            brands.text = beers //this displays a list of different beers that correspond to specific colors
            //brands.text = "Beer color is $color" //this shows the color corresponding to the selected item color
        }
    }

    // Function to determine grade letter based on integer input
    fun getGrade(grade_int: Int): String {
        return when {
            grade_int in 94..100 -> "A" // A grade 94 - 100
            grade_int in 90..93 -> "A-" // A- grade 90 - 93
            grade_int in 87..89 -> "B+" // B+ grade 87 - 89
            grade_int in 83..86 -> "B"  // B grade 83 - 86
            grade_int in 80..82 -> "B-" // B- grade 80 - 82
            grade_int in 77..79 -> "C+" // C+ grade 77 - 79
            grade_int in 73..76 -> "C"  // C grade 73 - 76
            grade_int in 70..72 -> "C-" // C- grade 70 - 72
            else -> "F" // Anything below 70 is an F
        }
    }

    fun getStudent(student: String) : List<String> {
        return when (student) {
            "Catherine Yabut" -> listOf("CIS", "4th Year")
            "Katie Trinh" -> listOf("CS", "4th Year")
            else -> listOf("unknown", "unknown")
        }
    }
}

// Big if for A, B, C, or F
// Small inner if for whether it's +, -, or regular letter
