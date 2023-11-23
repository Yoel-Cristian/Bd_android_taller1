package com.example.base

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class PantallaDeInsertarDatos : AppCompatActivity() {
    //declarando botones para mandar
    lateinit var txtInsertarNombre: TextView
    lateinit var txtInsertarPrecio: TextView
    lateinit var txtInsertarStock: TextView
    lateinit var btnInserDatos: Button
    lateinit var btnIrAMostrar: Button

    //Para el Spinner
    private lateinit var spinnerProductos: Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_de_insertar_datos2)

        //txtInsertarNombre=findViewById(R.id.txtInsertNombrer)
        txtInsertarPrecio=findViewById(R.id.txtInsertPrecio)
        //txtInsertarStock=findViewById(R.id.txtInsertStock)
        btnInserDatos=findViewById(R.id.btnInserDatos)
        btnIrAMostrar=findViewById(R.id.btnDirigirseAVentanaVer)

        var selectedProducto = ""

        //placeholder
        txtInsertarPrecio.hint="Cantidad"

        // Inicializar el Spinner
        spinnerProductos = findViewById(R.id.spinnerProductos)
        cargarNombresProductos()


        //Cada ves que se seleccione un item delllllllll spinner
        spinnerProductos.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Código que se ejecutará cuando se seleccione un elemento.
                var selectedProduct = parent?.getItemAtPosition(position).toString()
                selectedProducto = selectedProduct
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Código que se ejecutará cuando no se seleccione nada.
            }
        }

        btnInserDatos.setOnClickListener {
            //val nombre=txtInsertarNombre.text.toString()
            val precio=txtInsertarPrecio.text.toString()
            //val stock=txtInsertarStock.text.toString()
            enviarDatos(selectedProducto, precio)
        }



    }

    private fun cargarNombresProductos() {
        val gg=MyGlobals.miVariaIP
        val url = "http://$gg/ParaLaBaseDeDatosAndroid/listarNombresProductos.php"
        val requestQueue = Volley.newRequestQueue(this)

        val jsonArrayRequest = JsonArrayRequest(
            Request.Method.GET, url, null,
            { response ->
                // Procesar la respuesta JSON
                val nombresProductos = ArrayList<String>()

                for (i in 0 until response.length()) {
                    nombresProductos.add(response.getString(i))
                }

                // Configurar el adaptador para el Spinner
                val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, nombresProductos)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

                // Aplicar el adaptador al Spinner
                spinnerProductos.adapter = adapter
            },
            { error ->
                // Manejar el error (puedes mostrar un mensaje de error)
                Toast.makeText(this, "Error al cargar los nombres de los productos", Toast.LENGTH_SHORT).show()
            })

        // Agregar la solicitud a la cola
        requestQueue.add(jsonArrayRequest)
    }

    fun enviarDatos(nombre:String,precio:String){
        //val url = "http://$IP/ParaLaBaseDeDatosAndroid/insertar.php"
        val gg=MyGlobals.miVariaIP
        val jjjj=MyGlobals.idUsuarioGlobal
        val url = "http://$gg/ParaLaBaseDeDatosAndroid/insertarReserva.php"
        val requestQueue = Volley.newRequestQueue(this)

        val stringRequest = object : StringRequest(
            Method.POST, url,
            Response.Listener { response ->
                Toast.makeText(this, response, Toast.LENGTH_SHORT).show()
            },
            Response.ErrorListener { error ->
                // Manejar el error (puedes mostrar un mensaje de error)
                Toast.makeText(this, "Error al enviar datos", Toast.LENGTH_SHORT).show()
            }) {

            // Sobrescribir el método getParams para enviar los datos en el cuerpo de la solicitud
            override fun getParams(): Map<String, String> {
                val params = HashMap<String, String>()
                params["nombre"] = nombre
                params["cantidad"] = precio
                params["IDDD"] = jjjj
                return params
            }
        }

        // Agregar la solicitud a la cola
        requestQueue.add(stringRequest)
    }
}
