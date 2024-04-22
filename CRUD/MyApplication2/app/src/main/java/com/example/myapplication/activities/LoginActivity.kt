package com.example.myapplication.activities

import android.content.Intent
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
import com.example.myapplication.modelo.Cliente

class LoginActivity : AppCompatActivity() {
    private lateinit var user: EditText
    private lateinit var password: EditText
    private lateinit var btnLogin: AppCompatButton
    private lateinit var tvOlvideContraseña: TextView
    private lateinit var tvCrearCuenta: TextView

    private lateinit var cliente: Cliente


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initComponents()

        btnLogin.setOnClickListener (){
            Log.i("giusepe", "usuario: ${user.text}  password: ${password.text}")

            if (user.text.toString() == "admin" && password.text.toString() == "admin" ) {
                Log.i("giusepe", "Esta fino")
//                val intent = Intent(this, CreateAccountActivity::class.java)
//                intent.putExtra("EXTRA_USER",user.text.toString())
//                startActivity(intent)
            }else{
                Log.i("giusepe", "Algo salio mal")
            }
        }

        tvCrearCuenta.setOnClickListener(){
            val intent = Intent(this, CreateAccountActivity::class.java)
            intent.putExtra("EXTRA_USER",user.text.toString())
            startActivity(intent)
        }

    }
    private fun initComponents(){
        user = findViewById<AppCompatEditText>(R.id.etUser)
        password = findViewById<AppCompatEditText>(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvOlvideContraseña = findViewById(R.id.tvOlvideContraseña)
        tvCrearCuenta = findViewById(R.id.tvCrearCuenta)
    }
}