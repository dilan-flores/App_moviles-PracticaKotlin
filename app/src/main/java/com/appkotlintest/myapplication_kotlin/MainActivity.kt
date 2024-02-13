package com.appkotlintest.myapplication_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val txt_valor1 = findViewById<EditText>(R.id.txt_valor1)
        val txt_valor2 = findViewById<EditText>(R.id.txt_valor2)
        val txt_resultado = findViewById<TextView>(R.id.txt_resultado)
        val cb_sumar = findViewById<CheckBox>(R.id.cb_sumar)
        val cb_restar = findViewById<CheckBox>(R.id.cb_restar);
        cb_sumar.isChecked = true

        val botonCalcular = findViewById<Button>(R.id.btnCalcular)

        var resultado:String? = ""

        botonCalcular.setOnClickListener {
            if (txt_valor1.text.isNotEmpty() && txt_valor2.text.isNotEmpty()) {
                resultado = ""
                if (cb_sumar.isChecked) {
                    val suma = txt_valor1.text.toString().toLong() + txt_valor2.text.toString().toLong()
                    resultado = "La suma es: " + suma.toString() // Mensaje de suma con el resultado
                }
                if (cb_restar.isChecked) {
                    val resta = txt_valor1.text.toString().toLong() - txt_valor2.text.toString().toLong()
                    resultado = resultado + "\n La resta es: " + resta.toString() // Mensaje de resta con el resultado
                }

                txt_resultado.text = resultado ?: "" // Mostramos el resultado en el TextView, si es nulo, mostramos una cadena vacía
            } else {
                //notificación
                Toast.makeText(this, "Los dos campos son obligatorios", Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun boton(view: View) {
        when (view.id) {
            R.id.btn_siguiente -> {
                val intent = Intent(this, spinner::class.java)
                startActivity(intent)
            }
        }
    }
}