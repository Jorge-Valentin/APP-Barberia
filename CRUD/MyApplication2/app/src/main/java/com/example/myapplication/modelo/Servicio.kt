package com.example.myapplication.modelo

import com.example.myapplication.modelo.Conexion.ejecutarConsulta
import com.example.myapplication.modelo.Conexion.ejecutarSQL
import java.sql.SQLException

class Servicio(val idServicio: Int, var nombreServicio: String, var descripcionServicio: String,
               var precioServicio: Double, var estadoServicio: String, var idBarbero: Int) {
    companion object {

        fun crear(nombre: String,descripcion: String,precio: Double, estado: String, idBarbero: Int): Boolean {
            val sql = "INSERT INTO servicio(nombreServicio, descripcionServicio, precioServicio, estadoServicio, Barbero_idBarbero) " +
                    "VALUES('$nombre', '$descripcion', $precio, '$estado', $idBarbero)"
            return ejecutarSQL(sql)
        }

        fun obtenerTodos(): ArrayList<Servicio> {
            val listaServicios = ArrayList<Servicio>()
            val sql = "SELECT * FROM servicio"
            val resultSet = ejecutarConsulta(sql)

            try {
                while (resultSet!!.next()) {
                    val idServicio = resultSet.getInt("idServicio")
                    val nombre = resultSet.getString("nombreServicio")
                    val descripcion = resultSet.getString("descripcionServicio")
                    val precio = resultSet.getDouble("precioServicio")
                    val estado = resultSet.getString("estadoServicio")
                    val idBarbero = resultSet.getInt("Barbero_idBarbero")
                    listaServicios.add(
                        Servicio(idServicio, nombre, descripcion, precio, estado, idBarbero)
                    )
                }
            } catch (e: SQLException) {
                e.printStackTrace()
            } finally {
                resultSet?.close()
            }

            return listaServicios
        }

        fun actualizar(idServicio: Int,nombre: String,descripcion: String,precio: Double, estado: String, idBarbero: Int): Boolean {
            val sql = "UPDATE servicio SET nombreServicio='$nombre', descripcionServicio='$descripcion', " +
                    "precioServicio=$precio, estadoServicio='$estado', Barbero_idBarbero=$idBarbero " +
                    "WHERE idServicio=$idServicio"
            return ejecutarSQL(sql)
        }

        fun eliminar(idServicio: Int): Boolean {
            val sql = "DELETE FROM servicio WHERE idServicio=$idServicio"
            return ejecutarSQL(sql)
        }
    }

}