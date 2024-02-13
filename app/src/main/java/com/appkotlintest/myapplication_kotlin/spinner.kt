package com.appkotlintest.myapplication_kotlin

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class spinner : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.spinner)
        // Instanciasmos los componentes de la actividad
        val txt_valor1 = findViewById<EditText>(R.id.txt_valor1)
        val txt_valor2 = findViewById<EditText>(R.id.txt_valor2)
        val txt_resultado = findViewById<TextView>(R.id.txt_resultado)
        val  spinner = findViewById<Spinner>(R.id.spinneroptions)
        val botonOperar = findViewById<Button>(R.id.btnOperar)

        val opciones = arrayOf("Sumar", "Restar", "Multiplicar", "Dividir")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, opciones)
        spinner.adapter = adapter

        var resultado:String? = null

        botonOperar.setOnClickListener {
            if (txt_valor1.text.isNotEmpty() && txt_valor2.text.isNotEmpty()) {
                val valor1 = txt_valor1.text.toString().toDouble()
                val valor2 = txt_valor2.text.toString().toDouble()
                val operacionSeleccionada = spinner.selectedItem.toString()

                val resultado_operacion = when (operacionSeleccionada) {
                    "Sumar" -> valor1 + valor2
                    "Restar" -> valor1 - valor2
                    "Multiplicar" -> valor1 * valor2
                    "Dividir" -> if (valor2 != 0.0) valor1 / valor2 else null
                    else -> null
                }

                if (resultado_operacion != null) {
                    resultado = "Resultado: $resultado_operacion"
                    txt_resultado.text = resultado.toString()
                } else {
                    Toast.makeText(this, "No se puede dividir entre cero", Toast.LENGTH_SHORT).show()
                }
            } else {
                //notificación
                Toast.makeText(this, "Los dos campos son obligatorios", Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun boton(view: View) {
        when (view.id) {
            R.id.btn_atras -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_siguiente -> {
                val intent = Intent(this, listview::class.java)
                startActivity(intent)
            }
        }
    }
}