package com.example.base

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.base.crud_categoria.InsertarCategoria
import com.example.base.crud_categoria.MostrarCategoria
import com.example.base.crud_producto.ActualizarProducto
import com.example.base.crud_producto.InsertarProducto

class Categoria : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_categoria)
    }
    fun crud_productos(view: View) {
        val intent: Intent = when (view.id) {
            R.id.btnInsertar3 -> {
                Intent(this, InsertarCategoria::class.java).apply {
                    putExtra("opcion", "insertar")
                }
            }

            R.id.btnMostrar3-> {
                Intent(this, MostrarCategoria::class.java).apply {
                    putExtra("opcion", "Mostrar")
                }
            }

            else -> throw IllegalArgumentException("ID de vista desconocido")
        }
        startActivity(intent)
    }

}