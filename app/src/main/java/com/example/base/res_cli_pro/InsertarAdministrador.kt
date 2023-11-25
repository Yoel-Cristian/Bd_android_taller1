package com.example.res_cli_pro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.base.Ip
import com.example.base.R
import com.example.base.Registro
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.UnsupportedEncodingException
import java.net.URLEncoder

class InsertarAdministrador : AppCompatActivity() {

    private lateinit var nombre: EditText
    private lateinit var contraseña: EditText
    private lateinit var buttonSubmit: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insertar_administrador)

        nombre = findViewById(R.id.editTextText)
        contraseña = findViewById(R.id.editTextText2)
        buttonSubmit = findViewById(R.id.button)

        buttonSubmit.setOnClickListener {
            val nombreR = nombre.text.toString()
            val contraseñaR = contraseña.text.toString()
            insertarDatos(nombreR, contraseñaR)
            val toast = Toast.makeText(this, "Se Registro Correctamente", Toast.LENGTH_SHORT)
            toast.show()

            Handler(Looper.getMainLooper()).postDelayed({
                toast.cancel()
            }, 2000)

            val intent = Intent(this, InsertarAdministrador::class.java)
            CoroutineScope(Dispatchers.Main).launch {
                delay(2000) // Esperar 2 segundos
                startActivity(intent)
            }

        }
    }

    fun Atras(view: View?) {
        // Crear un Intent para abrir la nueva actividad
        val intent = Intent(this, Registro::class.java)
        // Iniciar la nueva actividad
        startActivity(intent)
    }
    fun Inicio(view: View?) {
        // Crear un Intent para abrir la nueva actividad
        val intent = Intent(this, Registro::class.java)
        // Iniciar la nueva actividad
        startActivity(intent)
    }
    fun Siguiente(view: View?) {
        // Crear un Intent para abrir la nueva actividad
        val intent = Intent(this, EliminarAdministrador::class.java)
        // Iniciar la nueva actividad
        startActivity(intent)
    }


    private fun insertarDatos (nombre: String, contraseña: String) {
        // Crear instancia de RequestQueue utilizando Volley
        val requestQueue: RequestQueue = Volley.newRequestQueue(this)
        // En cualquier otra clase
        var ip1=Ip.ip


        val url = "http://$ip1/demil/Administrador/Insertar_Registro.php"  // Reemplaza con la URL de tu script PHP

        // Crear una solicitud de cadena POST usando Volley
        val stringRequest = object : StringRequest(
            Request.Method.POST, url,
            Response.Listener<String> { response ->
                // Manejar la respuesta exitosa del servidor
                // Puedes mostrar un mensaje de éxito o realizar otras acciones aquí
            },
            Response.ErrorListener {
                // Manejar errores de la solicitud
                // Puedes mostrar un mensaje de error o realizar otras acciones aquí
            }) {

            override fun getParams(): Map<String, String> {
                val params = HashMap<String, String>()
                params["nombre"] = nombre
                params["contraseña"] = contraseña

                return params
            }

            @Throws(UnsupportedEncodingException::class)
            override fun getBody(): ByteArray {
                val params = getParams()
                val body = StringBuilder()
                for ((key, value) in params) {
                    body.append(URLEncoder.encode(key, "UTF-8"))
                        .append("=")
                        .append(URLEncoder.encode(value, "UTF-8"))
                        .append("&")
                }
                return body.toString().toByteArray(Charsets.UTF_8)
            }
        }
        requestQueue.add(stringRequest)
    }
}