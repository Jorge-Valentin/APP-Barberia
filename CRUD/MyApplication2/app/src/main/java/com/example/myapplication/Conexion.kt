package com.example.myapplication

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object Conexion {

        fun getConnection(): Connection? {
            var connection: Connection? = null
            try {
                Class.forName("com.mysql.jdbc.Driver")
                connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/barberia_db",
                    "root",
                    ""
                )
                println("Conexión exitosa")
            } catch (e: Exception) {
                println("Error al conectar a la base de datos:")
                e.printStackTrace()
            }
            return connection
        }

        fun ejecutarSQL(sql: String): Boolean {
            val connection = getConnection()
            return try {
                val statement = connection?.createStatement()
                statement?.execute(sql)
                true
            } catch (e: SQLException) {
                e.printStackTrace()
                false
            } finally {
                connection?.close()
            }
        }

        fun ejecutarConsulta(sql: String): java.sql.ResultSet? {
            val connection = getConnection()
            val statement = connection?.createStatement()
            val resultSet = statement?.executeQuery(sql)
            // No cerrar la conexión aquí
            return resultSet
        }
}