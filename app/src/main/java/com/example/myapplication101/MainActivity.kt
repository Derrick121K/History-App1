package com.example.myapplication101

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var ageEditText: EditText
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ageEditText = findViewById(R.id.ageEditText)
        resultTextView = findViewById(R.id.resultTextView)

        val calculateButton: Button = findViewById(R.id.submitButton)
        val clearButton: Button = findViewById(R.id.clearButton)

        calculateButton.setOnClickListener {
            calculateAgeComparison()
        }

        clearButton.setOnClickListener {
            clearFields()
        }
    }

    private fun calculateAgeComparison() {
        val ageText = ageEditText.text.toString()

        val age = null
        if (ageText.isNotEmpty()) {
            val age = ageText.toInt()
            val num1 = 20
            var num2 =96
            val historicalFigureInfo = getHistoricalFigureInfo(age)




            if (historicalFigureInfo !=null) {
                resultTextView.text = "You are the same age as ${historicalFigureInfo.name} when they died at ${historicalFigureInfo.ageAtDeath}"
            } else   {age <num1 || age >num2
                resultTextView.text = "No historical figure found for comparison."
            }
        } else
            {
                resultTextView.text = "Please enter your age"
            }
        }




    private fun ageText(intRange: IntRange) {val ageText = ageEditText.text.toString()

    }

    private fun clearFields() {
        ageEditText.text.clear()
        resultTextView.text = ""
    }
    private fun getHistoricalFigureInfo(age: Int): HistoricalFigureInfo? {
        var historicalFigures = listOf(
            HistoricalFigureInfo("Solomon Mahlangu", 22),
            HistoricalFigureInfo("Sarah Baartman", 26),
            HistoricalFigureInfo("Steve Biko", 30),
            HistoricalFigureInfo("Ota Benga", 32),
            HistoricalFigureInfo("Michael Jackson", 50),
            HistoricalFigureInfo("William Shakespeare", 52),
            HistoricalFigureInfo("Leonardo da Vinci", 67),
            HistoricalFigureInfo("Albert Einstein", 76),
            HistoricalFigureInfo("Winnie Mandela", 81),
            HistoricalFigureInfo("Nelson Mndela", 95),








     )
        return historicalFigures.firstOrNull { it.ageAtDeath >= age }
    }


    data class HistoricalFigureInfo(val name: String, val ageAtDeath: Int)
}

