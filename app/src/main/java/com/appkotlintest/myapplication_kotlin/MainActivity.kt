package com.appkotlintest.myapplication_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Instanciasmos los componentes de la actividad
        val txt_valor1 = findViewById<EditText>(R.id.txt_valor1)
        val txt_valor2 = findViewById<EditText>(R.id.txt_valor2)
        val botonCalcular = findViewById<Button>(R.id.btnCalcular)
        val txt_resultado = findViewById<TextView>(R.id.txt_resultado)
        //val grupo= findViewById<RadioGroup>(R.id.radioGroup)
        val rb_sumar = findViewById<RadioButton>(R.id.rb_sumar)
        val rb_restar = findViewById<RadioButton>(R.id.rb_restar);
        rb_sumar.isChecked = true

        var resultado:Long? = null

        botonCalcular.setOnClickListener{
            if(txt_valor1.text.isNotEmpty() && txt_valor2.text.isNotEmpty()){
                if(rb_sumar.isChecked()){
                    resultado = txt_valor1.text.toString().toLong() + txt_valor2.text.toString().toLong()
                    txt_resultado.text = resultado.toString()
                }else{
                    if(rb_restar.isChecked()){
                        resultado = txt_valor1.text.toString().toLong() - txt_valor2.text.toString().toLong()
                        txt_resultado.text = resultado.toString()
                    }
                }
            }else{
                //notificación
                Toast.makeText(this,"Los dos campos son obligatorios", Toast.LENGTH_SHORT).show()
            }
        }
    }
}