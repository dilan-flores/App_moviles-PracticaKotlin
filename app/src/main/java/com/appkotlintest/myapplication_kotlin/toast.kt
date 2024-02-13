package com.appkotlintest.myapplication_kotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class toast: AppCompatActivity() {

    val num = (Math.random() * 100001).toInt()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.toast)
        val cadena = num.toString()
        //notificación
        Toast.makeText(this, cadena, Toast.LENGTH_LONG).show()
    }
    fun boton(view: View) {
        when (view.id) {
            R.id.btn_atras -> {
                val intent = Intent(this, imagenbutton::class.java)
                startActivity(intent)
            }
            R.id.btn_controlar -> {
                val et1 = findViewById<EditText>(R.id.et_numero)
                val valorIngresado = et1.getText().toString();
                val valor=Integer.parseInt(valorIngresado).toInt()
                if(valor==num){
                    //notificación
                    Toast.makeText(this, "Muy bien recordaste el número", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this, "No es el número correcto", Toast.LENGTH_LONG).show()
                }

            }
        }
    }
}