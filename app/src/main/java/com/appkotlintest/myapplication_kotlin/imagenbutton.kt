package com.appkotlintest.myapplication_kotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class imagenbutton: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.imagenbutton)
    }
    fun boton(view: View) {
        when (view.id) {
            R.id.btn_atras -> {
                val intent = Intent(this, listview::class.java)
                startActivity(intent)
            }
            R.id.btn_imagen -> {
                val tv_text = findViewById<TextView>(R.id.tv_text)
                tv_text.setText("Haz hecho click en la imagen")
            }
            R.id.btn_siguiente -> {
                val intent = Intent(this, toast::class.java)
                startActivity(intent)
            }
        }
    }
}