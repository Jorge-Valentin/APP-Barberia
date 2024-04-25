package com.example.myapplication.activities

import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.modelo.Cliente
import com.example.myapplication.modelo.adapters.ClienteAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlin.random.Random

class CreateAccountActivity : AppCompatActivity() {
    private lateinit var nombres: EditText
    private lateinit var apellidos: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var btnRegistrar: AppCompatButton
    private lateinit var fabBack: FloatingActionButton

    private var firebase: FirebaseDatabase?= null
    private var databaseReference: DatabaseReference?= null


    private lateinit var rvClientes: RecyclerView
    private lateinit var clientesAdapter: ClienteAdapter
    private var listaClientes = mutableListOf<Cliente>()

    private var listaClientes2 = mutableListOf<Cliente>(
        Cliente(1,"adsd","asdasd","asdasd","asdasd")
    )



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
        firebase = FirebaseDatabase.getInstance()
        databaseReference = firebase?.getReference("personas")

        getData()
        //initUI()

        btnRegistrar.setOnClickListener(){
            val randomNumber = Random.nextInt(100)
            Log.i("giusepe", "Nombres:${nombres.text} apellidos: ${apellidos.text} ciudad: ${email.text} password:${password.text}")
            val cliente:Cliente = Cliente(randomNumber,nombres.text.toString(),apellidos.text.toString(),email.text.toString(),password.text.toString())
            databaseReference?.child(cliente.idCliente.toString())?.setValue(cliente)
        }

        fabBack.setOnClickListener(){
            onBackPressed()
        }

    }

    private fun initComponents(){
        nombres = findViewById<AppCompatEditText>(R.id.etNombres)
        apellidos = findViewById<AppCompatEditText>(R.id.etApellidos)
        email = findViewById<AppCompatEditText>(R.id.etEmail)
        password = findViewById<AppCompatEditText>(R.id.etPassword)
        btnRegistrar = findViewById(R.id.btnRegistar)
        fabBack = findViewById(R.id.fabBack)
        rvClientes = findViewById(R.id.rvClientes)
    }

    private fun getData(){
        Log.i("0000000000","entro al getdata")
        databaseReference?.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                Log.i("0000000000","onCanceled: ${snapshot}")
                listaClientes.clear()
                for (ds in snapshot.children){
                    val id = ds.key?.toInt() ?:0
                    val nombre = ds.child("nombreCliente").value.toString()
                    val apellidos = ds.child("apellidoCliente").value.toString()
                    val email = ds.child("correoCliente").value.toString()

                    val cliente = Cliente(id,nombre,apellidos,email,"1234")
                    listaClientes.add(cliente)
                }
                Log.i("0000000000","listSize ${listaClientes[0].nombreCliente.toString()}")
                clientesAdapter = ClienteAdapter(listaClientes)
                rvClientes.layoutManager = LinearLayoutManager(applicationContext)
                rvClientes.adapter = clientesAdapter
            }

            override fun onCancelled(error: DatabaseError) {
                Log.i("0000000000","onCanceled: ${error.toException()}")
            }
        })}

    private fun initUI(){
        clientesAdapter = ClienteAdapter(listaClientes)
        rvClientes.layoutManager = LinearLayoutManager(this)
        rvClientes.adapter = clientesAdapter
    }

}