package com.example.myapplication.modelo

import com.example.myapplication.modelo.Conexion.ejecutarConsulta
import com.example.myapplication.modelo.Conexion.ejecutarSQL
import java.sql.SQLException

class Cliente(val idCliente: Int, var nombreCliente: String, var apellidoCliente: String,
              var correoCliente: String, var passwordCliente: String) {
    companion object {

        fun crear(nombre: String, apellido: String, correo: String, password: String): Boolean {
            val sql =
                "INSERT INTO cliente(nombreCliente, apellidoCliente, correoCliente, passwordCliente) " +
                        "VALUES('$nombre', '$apellido', '$correo', '$password')"
            return ejecutarSQL(sql)
        }

        fun obtenerTodos(): ArrayList<Cliente> {
            val listaClientes = ArrayList<Cliente>()
            val sql = "SELECT * FROM cliente"
            val resultSet = ejecutarConsulta(sql)

            try {
                while (resultSet!!.next()) {
                    val idCliente = resultSet.getInt("idCliente")
                    val nombre = resultSet.getString("nombreCliente")
                    val apellido = resultSet.getString("apellidoCliente")
                    val correo = resultSet.getString("correoCliente")
                    val password = resultSet.getString("passwordCliente")
                    listaClientes.add(Cliente(idCliente, nombre, apellido, correo, password))
                }
            } catch (e: SQLException) {
                e.printStackTrace()
            } finally {
                resultSet?.close()
            }

            return listaClientes
        }

        fun actualizar(idCliente: Int, nombre: String, apellido: String, correo: String, password: String): Boolean {
            val sql = "UPDATE cliente SET nombreCliente='$nombre', apellidoCliente='$apellido', " +
                    "correoCliente='$correo', passwordCliente='$password' WHERE idCliente=$idCliente"
            return ejecutarSQL(sql)
        }


        fun eliminar(idCliente: Int): Boolean {
            val sql = "DELETE FROM cliente WHERE idCliente=$idCliente"
            return ejecutarSQL(sql)
        }

    }
}