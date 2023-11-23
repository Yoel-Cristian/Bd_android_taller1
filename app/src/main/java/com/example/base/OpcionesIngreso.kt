package com.example.base

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class OpcionesIngreso : AppCompatActivity() {
    private lateinit var textoNombre: TextView
    private lateinit var textoContrasena: TextView
    private lateinit var btnIngresarCliente: Button
    private lateinit var btnIngresarAdmind: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opciones_ingreso)
        var IPPP: String=""
        textoNombre = findViewById(R.id.editTextUsername)
        textoContrasena = findViewById(R.id.editTextPassword)
        btnIngresarCliente = findViewById(R.id.usuario)
        btnIngresarAdmind = findViewById(R.id.adm)



        btnIngresarCliente.setOnClickListener {
            val nombreUsuario = textoNombre.text.toString()
            val contrasena = textoContrasena.text.toString()
            autenticarUsuario(nombreUsuario, contrasena, "autenticarCliente")
        }

        btnIngresarAdmind.setOnClickListener {
            val nombreUsuario = textoNombre.text.toString()
            val contrasena = textoContrasena.text.toString()
            autenticarUsuario1(nombreUsuario, contrasena, "autenticarAdmind")
        }
    }



    private fun autenticarUsuario(nombreUsuario: String, contrasena: String, Dirrecion: String)
    {
        val gg = MyGlobals.miVariaIP
        val url = "http://$gg/ParaLaBaseDeDatosAndroid/$Dirrecion.php"
        val requestQueue = Volley.newRequestQueue(this)

        val stringRequest = object : StringRequest(Method.POST, url,
            Response.Listener { response ->
                // Procesar la respuesta del servidor
                if (response.startsWith("Autenticación exitosa")) {

                    // Extraer el ID del usuario de la respuesta
                    /*
                    Esta parte lo comente, no se para q se usa pero no produce un erro
                    y no de ja acceder ala ventana y cierra la app



                    val idUsuario = response.split("|")[1]      //produce error

                    // Almacenar el ID del usuario en una variable global
                    MyGlobals.idUsuarioGlobal = idUsuario

                    */

                    // Credenciales válidas, dirigir al usuario a otra ventana
                    val intent = Intent(this, PantallaDeInsertarDatos::class.java)
                    startActivity(intent)
                } else {
                    // Credenciales incorrectas, mostrar mensaje de error
                    Toast.makeText(this, "Error de autenticación", Toast.LENGTH_SHORT).show()
                }
            },
            Response.ErrorListener { error ->
                // Manejar el error (puedes mostrar un mensaje de error)
                Toast.makeText(this, "Error de conexión", Toast.LENGTH_SHORT).show()
            }) {

            // Sobrescribir el método getParams para enviar los datos en el cuerpo de la solicitud
            override fun getParams(): Map<String, String> {
                val params = HashMap<String, String>()
                params["nombreUsuario"] = nombreUsuario
                params["contrasena"] = contrasena
                return params
            }
        }

        // Agregar la solicitud a la cola
        requestQueue.add(stringRequest)
    }
    private fun autenticarUsuario1(nombreUsuario: String, contrasena: String, Dirrecion: String) {
        val gg = MyGlobals.miVariaIP
        val url = "http://$gg/ParaLaBaseDeDatosAndroid/$Dirrecion.php"
        val requestQueue = Volley.newRequestQueue(this)

        val stringRequest = object : StringRequest(
            Method.POST, url,
            Response.Listener { response ->
                // Procesar la respuesta del servidor
                if (response.startsWith("Autenticación exitosa")) {

                    val intent = Intent(this, personal::class.java)
                    startActivity(intent)


                } else {
                    // Credenciales incorrectas, mostrar mensaje de error
                    Toast.makeText(this, "Error de autenticación", Toast.LENGTH_SHORT).show()
                }
            },
            Response.ErrorListener { error ->
                // Manejar el error (puedes mostrar un mensaje de error)
                Toast.makeText(this, "Error de conexión", Toast.LENGTH_SHORT).show()
            }) {

            // Sobrescribir el método getParams para enviar los datos en el cuerpo de la solicitud
            override fun getParams(): Map<String, String> {
                val params = HashMap<String, String>()
                params["nombreUsuario"] = nombreUsuario
                params["contrasena"] = contrasena
                return params
            }
        }

        // Agregar la solicitud a la cola
        requestQueue.add(stringRequest)
    }


}