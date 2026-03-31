package com.mgc.laboratorio04

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TimePicker
import android.widget.Toast

class TimePickerFragment : Fragment() {

    private lateinit var timePicker: TimePicker

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_time_picker, container, false)

        timePicker = view.findViewById(R.id.timePicker)
        timePicker.setIs24HourView(true)

        val boton = view.findViewById<View>(R.id.btnConfigurar)
        boton.setOnClickListener {

            val hora = timePicker.hour
            val minuto = timePicker.minute

            Toast.makeText(
                requireContext(),
                "Hora seleccionada $hora:$minuto",
                Toast.LENGTH_SHORT
            ).show()
        }

        return view
    }
}
