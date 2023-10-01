package com.example.dobcalc

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.DatePicker
import android.widget.Toast
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker : Button = findViewById(R.id.button)
        btnDatePicker.setOnClickListener {
            clickDatePicker()
        }
    }

    fun clickDatePicker(){
        val myClender = Calendar.getInstance()
        val year = myClender.get(Calendar.YEAR)
        val month = myClender.get(Calendar.MONTH)
        val day = myClender.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this , DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
//            Toast.makeText(this , "Btn date picker displayed" , Toast.LENGTH_LONG).show()
        },
            year,
            month,
            day
        ).show()


    }

}