package com.example.base

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.base.crud_producto.ActualizarProducto
import com.example.base.crud_producto.InsertarProducto
import com.example.base.crud_producto.MostrarProducto

class Producto : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto)



    }
    fun crud_productos(view: View) {
        val intent: Intent = when (view.id) {
            R.id.btnInsertar1 -> {
                Intent(this, InsertarProducto::class.java).apply {
                    putExtra("opcion", "insertar")
                }
            }

            R.id.btnMostrar1-> {
                Intent(this, MostrarProducto::class.java).apply {
                    putExtra("opcion", "Mostrar")
                }
            }

            else -> throw IllegalArgumentException("ID de vista desconocido")
        }
        startActivity(intent)
    }
}