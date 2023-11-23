package com.example.base



import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.RequestQueue

import com.android.volley.toolbox.Volley


class MainActivity : AppCompatActivity() {

    private lateinit var txResultado: TextView

    private lateinit var mandarIpButton: Button
    private lateinit var queue: RequestQueue

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var IPPP: String=""
        // Inicializar las vistas
        txResultado = findViewById(R.id.ip_conexion)
        mandarIpButton = findViewById(R.id.conexion)
        // Inicializar la cola de solicitudes Volley
        queue = Volley.newRequestQueue(this)

        // Configurar el click listener para el botón MandarIp
        mandarIpButton.setOnClickListener {
            Ip.ip=txResultado.text.toString()
            val toast = Toast.makeText(this, "Se conecto correctamente al Servidor: ${Ip.ip}", Toast.LENGTH_SHORT)
            toast.show()

            Handler(Looper.getMainLooper()).postDelayed({
                toast.cancel()
            }, 2000)
            val nuevaIp = txResultado.text.toString()
            IPPP=nuevaIp
            MyGlobals.miVariaIP=nuevaIp

            val intent = Intent(this, OpcionesIngreso::class.java)
            startActivity(intent)
        }
    }
}

















