package com.example.myapplication.modelo.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.modelo.Cliente
import com.example.myapplication.R

class ClienteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val nombres:TextView = view.findViewById(R.id.tvNombres)
    private val apellidos:TextView = view.findViewById(R.id.tvApellidos)
    private val correo:TextView = view.findViewById(R.id.tvCorreos)
    fun render(cliente: Cliente){
        nombres.text = cliente.nombreCliente
        apellidos.text = cliente.apellidoCliente
        correo.text = cliente.correoCliente
    }
}