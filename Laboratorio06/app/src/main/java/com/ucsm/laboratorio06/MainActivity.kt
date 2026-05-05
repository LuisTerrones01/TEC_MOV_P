package com.ucsm.laboratorio06

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowCircleDown

import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ucsm.laboratorio06.ui.theme.Laboratorio06Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio06Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FormularioUsuario(modifier = Modifier.padding(innerPadding))
                }
            }
        }

    }
}
@Composable
fun FormularioUsuario(modifier: Modifier = Modifier) {
    var nombre by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 50.dp, vertical = 200.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedTextField(
            //como hacer para que en el log aparezca cuando ingrese el nombre
            value = nombre,

            onValueChange = { nuevo ->
                if (nuevo.length <= 9) {
                    nombre = nuevo
                    Log.d("FormularioUsuario", "Nombre ingresado: $nuevo")
                }
                if (nuevo.length == 9){
                    Log.d("FormularioUsuarioCompleto","NombreCompleto: $nuevo")
                }
            },


            label = { Text("Ingresa tu nombre") },
            supportingText = { Text("Aquí ingresa tu nombre · ${nombre.length}/9") },
            trailingIcon = {
                if (nombre.isNotEmpty()) {
                    val context = LocalContext.current
                    IconButton(onClick = {
                        Toast.makeText(context,"Nombre: "+nombre+" Eliminado",Toast.LENGTH_LONG).show()
                        nombre = ""

                    }) {
                        Icon(Icons.Default.ArrowCircleDown, contentDescription = "Limpiar")
                    }
                }
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
@Preview(showBackground = true)
@Composable
fun FormularioUsuarioPreview() {
    Laboratorio06Theme { FormularioUsuario() }
}
