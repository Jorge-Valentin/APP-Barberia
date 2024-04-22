package com.example.myapplication.activities

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CreateAccountActivity : AppCompatActivity() {
    private lateinit var nombres: EditText
    private lateinit var apellidos: EditText
    private lateinit var ciudad: EditText
    private lateinit var password: EditText
    private lateinit var btnRegistrar: AppCompatButton
    private lateinit var fabBack: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_create_account)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initComponents()

        btnRegistrar.setOnClickListener(){
            Log.i("giusepe", "Nombres:${nombres.text} apellidos: ${apellidos.text} ciudad: ${ciudad.text} password:${password.text}")
        }

        fabBack.setOnClickListener(){
            onBackPressed()
        }

    }

    private fun initComponents(){
        nombres = findViewById<AppCompatEditText>(R.id.etNombres)
        apellidos = findViewById<AppCompatEditText>(R.id.etApellidos)
        ciudad = findViewById<AppCompatEditText>(R.id.etCiudad)
        password = findViewById<AppCompatEditText>(R.id.etPassword)
        btnRegistrar = findViewById(R.id.btnRegistar)
        fabBack = findViewById(R.id.fabBack)
    }

}