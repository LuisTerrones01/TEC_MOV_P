package com.mgc.laboratorio04

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var menu: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        menu = findViewById(R.id.bottom_nav)

        // Fragment inicial
        cargarFragment(AutocompleteFragment())

        menu.setOnItemSelectedListener { item ->

            when (item.itemId) {
                R.id.nav_auto -> {
                    cargarFragment(AutocompleteFragment())
                    true
                }

                R.id.nav_date -> {
                    cargarFragment(DatePickerFragment())
                    true
                }

                R.id.nav_time -> {
                    cargarFragment(TimePickerFragment())
                    true
                }
                R.id.nav_nuevo -> {
                    cargarFragment(TimePickerFragment())
                    true
                }


                else -> false
            }
        }
    }

    private fun cargarFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.contenedor, fragment)
            .commit()
    }
}

