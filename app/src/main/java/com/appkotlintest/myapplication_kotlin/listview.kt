package com.appkotlintest.myapplication_kotlin

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class listview : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listview)
        val tv1 = findViewById<TextView>(R.id.txt_text)
        val lv1 = findViewById<ListView>(R.id.listView)
        val paises = arrayOf("Argentina", "Chile", "Paraguay", "Bolivia", "Peru", "Ecuador", "Brasil", "Colombia")
        val habitantes = arrayOf("4000000", "17000000", "6500000", "1000000", "30000000", "14000000", "183000000", "44000000")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, paises)
        lv1.adapter = adapter

        lv1.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val paisSeleccionado = paises[position]
            val habitantesPais = habitantes[position]
            val mensaje = "$paisSeleccionado tiene $habitantesPais habitantes"
            tv1.text = mensaje
        }
    }

    fun boton(view: View) {
        when (view.id) {
            R.id.btn_atras -> {
                val intent = Intent(this, spinner::class.java)
                startActivity(intent)
            }
            R.id.btn_siguiente -> {
                val intent = Intent(this, imagenbutton::class.java)
                startActivity(intent)
            }
        }
    }
}