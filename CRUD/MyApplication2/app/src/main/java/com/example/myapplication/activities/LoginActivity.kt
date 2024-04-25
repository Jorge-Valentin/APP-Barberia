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
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.modelo.Cliente
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.FirebaseDatabase.getInstance
import com.google.firebase.database.ValueEventListener

class LoginActivity : AppCompatActivity() {
    private lateinit var user: EditText
    private lateinit var password: EditText
    private lateinit var btnLogin: AppCompatButton
    private lateinit var tvOlvideContraseña: TextView
    private lateinit var tvCrearCuenta: TextView


    private var firebase:FirebaseDatabase ?= null
    private var databaseReference:DatabaseReference ?= null
    private var listaClientes = mutableListOf<Cliente>()



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
        firebase = FirebaseDatabase.getInstance()
        databaseReference = firebase?.getReference("personas")
        //getData()

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

    private fun getData(){
        databaseReference?.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                Log.i("0000000000","onCanceled: ${snapshot}")
                for (ds in snapshot.children){
                    val id = ds.key?.toInt() ?:0
                    val nombre = ds.child("nombres").value.toString()
                    val apellidos = ds.child("apellidos").value.toString()
                    val email = ds.child("email").value.toString()
                    val password = ds.child("password").value.toString()
                    val cliente = Cliente(id,nombre,apellidos,email,password)
                    listaClientes.add(cliente)
                }
                Log.i("0000000000","listSize ${listaClientes.size}")

            }

            override fun onCancelled(error: DatabaseError) {
                Log.i("0000000000","onCanceled: ${error.toException()}")
            }
        })}


}

