package com.example.base

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.res_cli_pro.InsertarAdministrador
import com.example.res_cli_pro.InsertarCliente

class Registro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
    }
    fun Insertar_Cliente(view: View?) {
        // Crear un Intent para abrir la nueva actividad
        val intent = Intent(this, InsertarCliente::class.java)
        // Iniciar la nueva actividad
        startActivity(intent)
    }
    fun Insertar_Administrador(view: View?) {
        // Crear un Intent para abrir la nueva actividad
        val intent = Intent(this, InsertarAdministrador::class.java)
        // Iniciar la nueva actividad
        startActivity(intent)
    }

    fun Ingresar_Sistema(view: View?) {
        // Crear un Intent para abrir la nueva actividad
        val intent = Intent(this, OpcionesIngreso::class.java)
        // Iniciar la nueva actividad
        startActivity(intent)
    }
}