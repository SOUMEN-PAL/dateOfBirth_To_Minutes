package com.example.dobcalc

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CalendarView
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import java.lang.NullPointerException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private var tvInMinutes : TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker = findViewById<Button>(R.id.button)
        btnDatePicker.setOnClickListener {
            clickDatePicker()
        }
    }

    fun clickDatePicker(){
        val selectedDate : TextView = findViewById(R.id.tv4)
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val date = calendar.get(Calendar.DAY_OF_MONTH)
        val datePicker = DatePickerDialog(this ,
            DatePickerDialog.OnDateSetListener{ view , year , month , day ->
                var date:String = "$day.${month+1}.$year"
                selectedDate.text = date
                tvInMinutes = findViewById(R.id.tv6)
                var res = toMinutes(date)
                tvInMinutes?.text = res
            },
            year,
            month,
            date
        )
        datePicker.show()

    }

    fun toMinutes(date:String):String{
        val sdf = SimpleDateFormat("dd.MM.yyyy" , Locale.ENGLISH)
        val theDate = sdf.parse(date)
        val selectedDateInMinutes = theDate.time/60000
        val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
        val currentDateInMinutes = currentDate.time/60000
        val differenceMinutes = currentDateInMinutes - selectedDateInMinutes
        return differenceMinutes.toString()
    }

}