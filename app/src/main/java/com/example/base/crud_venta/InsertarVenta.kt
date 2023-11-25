package com.example.base.crud_venta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.base.R

class InsertarVenta : AppCompatActivity() {
    private lateinit var editTextClienteID: EditText
    private lateinit var editTextFechaVenta: EditText
    private lateinit var editTextTotalVenta: EditText
    private lateinit var btnRegistrarVenta: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insertar_venta)

        editTextClienteID = findViewById(R.id.editTextClienteID)
        editTextFechaVenta = findViewById(R.id.editTextFechaVenta)
        editTextTotalVenta = findViewById(R.id.editTextTotalVenta)
        btnRegistrarVenta = findViewById(R.id.btnRegistrarVenta)

        // Ahora puedes usar estas variables para trabajar con los elementos en tu código
        btnRegistrarVenta.setOnClickListener {
            // Código a ejecutar cuando se hace clic en el botón
            // Puedes acceder a las variables declaradas arriba (por ejemplo, editTextClienteID.text.toString())
        }
    }
}