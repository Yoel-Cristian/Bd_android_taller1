package com.example.res_cli_pro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.base.Ip
import com.example.base.R
import com.example.base.Registro
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class EliminarCliente : AppCompatActivity() {

    private lateinit var spinnerRegistroCliente: Spinner
    var ip1=Ip.ip

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eliminar_cliente)

        var SelecClientes = ""

        // Inicializar el Spinner
        spinnerRegistroCliente = findViewById(R.id.spinnerRegistroCliente)
        CargarNombreRegistroCliente()


        //Cada ves que se seleccione un item delllllllll spinner
        spinnerRegistroCliente.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Código que se ejecutará cuando se seleccione un elemento.
                var selectedNombres = parent?.getItemAtPosition(position).toString()
                SelecClientes= selectedNombres
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Código que se ejecutará cuando no se seleccione nada.
            }

        }

        val eliminar1=findViewById<Button>(R.id.button3)
        eliminar1.setOnClickListener {
            var id=findViewById<EditText>(R.id.editTextPhone)
            EliminarDatos(id.text.toString())
            CargarNombreRegistroCliente()

            val intent = Intent(this, EliminarCliente::class.java)
            CoroutineScope(Dispatchers.Main).launch {
                delay(1000) // Esperar 2 segundos
                startActivity(intent)
            }

        }

        val actualizar=findViewById<Button>(R.id.button4)
        actualizar.setOnClickListener {
            var id=findViewById<EditText>(R.id.editTextPhone)
            Ip.id_actualizar=id.text.toString()
            val intent = Intent(this, ActualizarCliente::class.java)
            startActivity(intent)
        }

    }

    fun Atras(view: View?) {
        // Crear un Intent para abrir la nueva actividad
        val intent = Intent(this, InsertarCliente::class.java)
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
        val intent = Intent(this, ActualizarCliente::class.java)
        // Iniciar la nueva actividad
        startActivity(intent)
    }

    private fun CargarNombreRegistroCliente() {

        var url = "http://$ip1/demil/Cliente/listar_Registro.php" // servicio web cambiarddddddd

        val requestQueue = Volley.newRequestQueue(this)

        val jsonArrayRequest = JsonArrayRequest(
            Request.Method.GET, url, null,
            { response ->
                // Procesar la respuesta JSON
                val nombresRegistro = ArrayList<String>()

                for (i in 0 until response.length()) {
                    nombresRegistro.add(response.getString(i))
                }

                // Configurar el adaptador para el Spinner
                val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, nombresRegistro)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

                // Aplicar el adaptador al Spinner
                spinnerRegistroCliente.adapter = adapter
            },
            { error ->
                // Manejar el error (puedes mostrar un mensaje de error)
                Toast.makeText(this, "Error al Registrarse", Toast.LENGTH_SHORT).show()
            })

        // Agregar la solicitud a la cola
        requestQueue.add(jsonArrayRequest)
    }

    fun EliminarDatos(idRegistro: String){

        val url = "http://$ip1/demil/Cliente/eliminar_Registro.php"
        val requestQueue = Volley.newRequestQueue(this)

        val stringRequest = object : StringRequest(
            Method.POST, url,
            Response.Listener { response ->
                // Procesar la respuesta del servidor (puedes mostrar un mensaje de éxito, por ejemplo)
                Toast.makeText(this, response, Toast.LENGTH_SHORT).show()
            },
            Response.ErrorListener { error ->
                // Manejar el error (puedes mostrar un mensaje de error)
                Toast.makeText(this, "Error al Eliminar", Toast.LENGTH_SHORT).show()
            }) {

            // Sobrescribir el método getParams para enviar el ID del producto en el cuerpo de la solicitud
            override fun getParams(): Map<String, String> {
                val params = HashMap<String, String>()
                params["idRegistro"] = idRegistro
                return params
            }
        }

        // Agregar la solicitud a la cola
        requestQueue.add(stringRequest)
    }



}