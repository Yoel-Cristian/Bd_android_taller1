package com.example.base

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class personal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal)
    }
    fun onButtonClick(view: View) {
        val intent: Intent = when (view.id) {
            R.id.btnProductos -> {
                Intent(this, Producto::class.java).apply {
                    putExtra("opcion", "Productos")
                }
            }
            R.id.btnClientes -> {
                Intent(this, Cliente::class.java).apply {
                    putExtra("opcion", "Clientes")
                }
            }
            R.id.btnProveedores -> {
                Intent(this, Proveedores::class.java).apply {
                    putExtra("opcion", "Proveedores")
                }
            }
            R.id.btnCategorias -> {
                Intent(this, Categoria::class.java).apply {
                    putExtra("opcion", "Categorías")
                }
            }
            R.id.btnVentas -> {
                Intent(this, Venta::class.java).apply {
                    putExtra("opcion", "Ventas")
                }
            }
            R.id.btnDetallesVenta -> {
                Intent(this, DetalleVenta::class.java).apply {
                    putExtra("opcion", "Detalles de Venta")
                }
            }
            R.id.salir -> {
                finish()
                return
            }
            else -> throw IllegalArgumentException("ID de vista desconocido")
        }
        startActivity(intent)
    }

}