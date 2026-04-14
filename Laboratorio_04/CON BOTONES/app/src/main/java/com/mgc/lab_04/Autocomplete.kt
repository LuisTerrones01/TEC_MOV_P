package com.mgc.lab_04

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.content.Intent
import android.widget.Button
import android.widget.DatePicker
import android.widget.TimePicker


class Autocomplete : AppCompatActivity() {
    val presidents = arrayOf(
        "José Luis Bustamante",
        "Zenón Noriega",
        "Manuel Odriá",
        "Manuel Prado",
        "Fco Morales Bermúdez",
        "Fernando Belaunde",
        "Alberto Fujimori",
        "Valentín Paniagua",
        "Alejandro Toledo",
        "Alan García",
        "Pedro Pablo Kuczynski",
        "Martín Alberto Vizcarra",
        "Pedro Castillo Terrones",
        "Dina Boluarte Zegarra",
        "Jose Jeri Ore"
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_autocomplete)
        val adapter = ArrayAdapter(this,
            android.R.layout.simple_dropdown_item_1line, presidents)
        val textView =
            findViewById<AutoCompleteTextView>(R.id.txtPresidentes)
        textView.threshold = 3
        textView.setAdapter(adapter)

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
}
