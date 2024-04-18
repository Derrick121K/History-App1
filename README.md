ACTIVITY MAIN

<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/history"
    tools:context=".MainActivity">

    <Button
        android:id="@+id/submitButton"
        android:layout_width="113dp"
        android:layout_height="55dp"
        android:layout_below="@id/ageEditText"
        android:background="#CBCA7F47"
        android:text="Submit"
        android:textColor="#FF6D00"
        android:layout_centerHorizontal="true"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.498"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.47" />

    <EditText
        android:id="@+id/ageEditText"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_margin="16dp"
        android:background="#985420"
        android:hint="Enter your age"
        android:inputType="number"
        android:padding="8dp"
        android:textColor="#3061EA"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.374" />

    <ImageView
        android:id="@+id/myImageView"
        android:layout_width="289dp"
        android:layout_height="201dp"
        android:layout_gravity="center_horizontal"
        android:src="@drawable/his"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.426"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.083" />


    <TextView
        android:id="@+id/resultTextView"
        android:layout_width="344dp"
        android:layout_height="269dp"
        android:layout_below="@id/submitButton"
        android:background="@drawable/time"
        android:gravity="center"
        android:text=""
        android:textColor="@android:color/black"
        android:textSize="40sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.637"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.853" />

    <Button
        android:id="@+id/clearButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@id/resultTextView"
        android:layout_centerHorizontal="true"
        android:text="Clear"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.538"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.976" />

</androidx.constraintlayout.widget.ConstraintLayout>)


MAINACTIVITY

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
