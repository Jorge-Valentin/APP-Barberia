package com.example.myapplication.modelo.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.modelo.Cliente
import com.example.myapplication.R





class ClienteAdapter(private val clientes: List<Cliente>) :
    RecyclerView.Adapter<ClienteViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClienteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cliente, parent,false)
        return ClienteViewHolder(view)
    }

    override fun getItemCount() = clientes.size


    override fun onBindViewHolder(holder: ClienteViewHolder, position: Int) {
        holder.render(clientes[position])
    }


}