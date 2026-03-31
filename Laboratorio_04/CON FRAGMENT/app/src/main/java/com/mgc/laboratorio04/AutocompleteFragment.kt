package com.mgc.laboratorio04

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView

class AutocompleteFragment : Fragment() {

    private val presidents = arrayOf(
        "José Luis Bustamante",
        "Zenón Noriega",
        "Manuel Odría",
        "Manuel Prado",
        "Fco Morales Bermúdez",
        "Fernando Belaunde",
        "Alberto Fujimori",
        "Valentín Paniagua",
        "Alejandro Toledo",
        "Alan García",
        "Pedro Pablo Kuczynski",
        "Martín Vizcarra",
        "Pedro Castillo",
        "Dina Boluarte",
        "Jose Jeri Ore"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_autocomplete, container, false)

        val textView = view.findViewById<AutoCompleteTextView>(R.id.txtPresidentes)

        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_dropdown_item_1line,
            presidents
        )

        textView.threshold = 1
        textView.setAdapter(adapter)

        return view
    }
}