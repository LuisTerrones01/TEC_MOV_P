package com.mgc.lab_04

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var timePicker: TimePicker
    private lateinit var datePicker: DatePicker




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timePicker = findViewById(R.id.timePicker)
        datePicker = findViewById(R.id.datePicker)
        timePicker.setIs24HourView(true)

        val btn1 = findViewById<Button>(R.id.btnAct1)
        val btn2 = findViewById<Button>(R.id.btnAct2)
        val btn3 = findViewById<Button>(R.id.btnAct3)


        btn1.setOnClickListener {
            startActivity(Intent(this, Autocomplete::class.java))
        }

        btn2.setOnClickListener {
            startActivity(Intent(this, DatePicker1::class.java))
        }

        btn3.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    fun onClick(view: View) {

        val hora: Int
        val minuto: Int

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            hora = timePicker.hour
            minuto = timePicker.minute
        } else {
            hora = timePicker.currentHour
            minuto = timePicker.currentMinute
        }

        val dia = datePicker.dayOfMonth
        val mes = datePicker.month + 1
        val anio = datePicker.year

        Toast.makeText(
            this,
            "Fecha: $dia/$mes/$anio Hora: $hora:$minuto",
            Toast.LENGTH_SHORT
        ).show()
    }
}