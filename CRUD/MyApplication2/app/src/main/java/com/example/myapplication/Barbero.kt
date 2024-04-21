package com.example.myapplication

import com.example.myapplication.Conexion.ejecutarConsulta
import com.example.myapplication.Conexion.ejecutarSQL
import java.sql.SQLException


class Barbero(val id: Int, var correo: String, var password: String) {
    companion object {

        fun crear(correo: String, password: String, nombre: String, apellido: String, apodo: String, descripcion: String, telefono: String, foto: String, idBarberia: String): Boolean {
            val sql = "INSERT INTO barbero(correoBarbero, passwordBarbero, nombreBarbero, apellidoBarbero, apodoBarbero, descripcionBarbero, telefonoBarbero, contenidoFotoPerfilBarbero, Barberia_idBarberia) " +
                    "VALUES('$correo', '$password', '$nombre', '$apellido', '$apodo', '$descripcion', '$telefono', '$foto', '$idBarberia')"
            return ejecutarSQL(sql)
        }


        fun obtenerTodos(): ArrayList<Barbero> {
            val listaBarberos = ArrayList<Barbero>()
            val sql = "SELECT * FROM barbero"
            val resultSet = ejecutarConsulta(sql)

            try {
                while (resultSet!!.next()) {
                    val id = resultSet.getInt("idBarbero")
                    val correo = resultSet.getString("correoBarbero")
                    val password = resultSet.getString("passwordBarbero")
                    listaBarberos.add(Barbero(id, correo, password))
                }
            } catch (e: SQLException) {
                e.printStackTrace()
            } finally {
                resultSet?.close()
            }

            return listaBarberos
        }

        fun actualizar(id: Int, correo: String, password: String): Boolean {
            val sql = "UPDATE barbero SET correoBarbero='$correo', passwordBarbero='$password' WHERE idBarbero=$id"
            return ejecutarSQL(sql)
        }

        fun eliminar(id: Int): Boolean {
            val sql = "DELETE FROM barbero WHERE idBarbero=$id"
            return ejecutarSQL(sql)
        }



    }
}
