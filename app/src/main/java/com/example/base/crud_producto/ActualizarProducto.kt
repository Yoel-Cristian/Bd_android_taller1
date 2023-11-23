package com.example.base.crud_producto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.*
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.base.Ip
import com.example.base.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.UnsupportedEncodingException
import java.net.URLEncoder

class ActualizarProducto : AppCompatActivity() {
    var ip1=Ip.ip
    private lateinit var spinnerProductos: Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar_producto)


        var selectedProducto = ""


        // Inicializar el Spinner
        spinnerProductos = findViewById(R.id.lista_ca)
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

        // Inicializar vistas
        var etNombre: EditText = findViewById(R.id.nom_producto)
        var etDescripcion: EditText = findViewById(R.id.des_prodcuto)
        var etPrecio: EditText = findViewById(R.id.precio_p)
        var etStock: EditText = findViewById(R.id.stock_producto)

        var btnEnviar: Button = findViewById(R.id.btnEnviar)
        // Configurar el click del botón
        btnEnviar.setOnClickListener {
            // Obtener valores de las vistas
            val nombre = etNombre.text.toString()
            val descripcion = etDescripcion.text.toString()
            val precio = etPrecio.text.toString().toDouble()
            val stock = etStock.text.toString().toInt()
            val categoriaID = selectedProducto  // Obtener el elemento seleccionado
            insertarDatos(Ip.id_actualizar,nombre, descripcion, precio, stock, categoriaID)
            val toast = Toast.makeText(this, "Se Actualizaron datos correctamente", Toast.LENGTH_SHORT)
            toast.show()
            Handler(Looper.getMainLooper()).postDelayed({
                toast.cancel()
            }, 2000)
            Ip.id_actualizar=""
            val intent = Intent(this, MostrarProducto::class.java)
            CoroutineScope(Dispatchers.Main).launch {
                delay(2000) // Esperar 2 segundos
                startActivity(intent)
            }
        }
    }
    private fun cargarNombresProductos() {

        var url = "http://$ip1/demil/listar_categoria2.php" // servicio web

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

    private fun insertarDatos(
        id_pro:String,
        nombre: String,
        descripcion: String,
        precio: Double,
        stock: Int,
        categoriaID: String
    ) {
        // Crear instancia de RequestQueue utilizando Volley
        val requestQueue: RequestQueue = Volley.newRequestQueue(this)
        // En cualquier otra clase

        var ip1= Ip.ip
        val url = "http://$ip1/demil/actualizar_producto.php"  // Reemplaza con la URL de tu script PHP

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
                params["id"]=id_pro
                params["nombre"] = nombre
                params["descripcion"] = descripcion
                params["precio"] = precio.toString()
                params["stock"] = stock.toString()
                params["categoriaID"] = categoriaID
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

        // Agregar la solicitud a la cola
        requestQueue.add(stringRequest)
    }


}
