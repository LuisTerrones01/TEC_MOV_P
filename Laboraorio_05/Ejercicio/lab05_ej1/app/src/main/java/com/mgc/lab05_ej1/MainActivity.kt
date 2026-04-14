package com.mgc.lab05_ej1

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private lateinit var prefs: SharedPreferences
    private lateinit var lista: ArrayList<Producto>
    private lateinit var adapter: ProductoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etCantidad = findViewById<EditText>(R.id.etCantidad)
        val etPrecio = findViewById<EditText>(R.id.etPrecio)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)
        val recycler = findViewById<RecyclerView>(R.id.recyclerProductos)

        prefs = getSharedPreferences("productos", MODE_PRIVATE)
        lista = cargarProductos()

        adapter = ProductoAdapter(lista)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter

        btnGuardar.setOnClickListener {
            val nombre = etNombre.text.toString()
            val cantidad = etCantidad.text.toString().toInt()
            val precio = etPrecio.text.toString().toDouble()

            val producto = Producto(nombre, cantidad, precio)
            lista.add(producto)

            guardarProductos(lista)
            adapter.notifyDataSetChanged()

            etNombre.text.clear()
            etCantidad.text.clear()
            etPrecio.text.clear()
        }
    }

    private fun guardarProductos(lista: List<Producto>) {
        val jsonArray = JSONArray()

        for (p in lista) {
            val obj = JSONObject()
            obj.put("nombre", p.nombre)
            obj.put("cantidad", p.cantidad)
            obj.put("precio", p.precio)
            jsonArray.put(obj)
        }

        prefs.edit().putString("lista", jsonArray.toString()).apply()
    }

    private fun cargarProductos(): ArrayList<Producto> {
        val lista = ArrayList<Producto>()
        val json = prefs.getString("lista", null)

        if (json != null) {
            val jsonArray = JSONArray(json)
            for (i in 0 until jsonArray.length()) {
                val obj = jsonArray.getJSONObject(i)
                lista.add(
                    Producto(
                        obj.getString("nombre"),
                        obj.getInt("cantidad"),
                        obj.getDouble("precio")
                    )
                )
            }
        }

        return lista
    }
}