package com.example.base.crud_producto

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
import com.example.base.Ip
import com.example.base.R
import com.example.base.crud_categoria.ActualizarCategoria

class MostrarProducto : AppCompatActivity() {
    private lateinit var spinnerProductos: Spinner
    var ip1=Ip.ip
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_producto)
        var selectedProducto = ""


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

        val eliminar1=findViewById<Button>(R.id.eliminar_p)
        eliminar1.setOnClickListener {
            var id=findViewById<EditText>(R.id.id_eliminar)
            EliminarDatos(id.text.toString())
            cargarNombresProductos()
        }

        val actualizar=findViewById<Button>(R.id.actualizar_p)
        actualizar.setOnClickListener {
            var id2=findViewById<EditText>(R.id.id_eliminar)
            Ip.id_actualizar=id2.text.toString()
            val intent = Intent(this, ActualizarProducto::class.java)
            startActivity(intent)
        }

    }
    private fun cargarNombresProductos() {

        var url = "http://$ip1/demil/listar_producto.php" // servicio web

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

    fun EliminarDatos(idProducto: String){

        val url = "http://$ip1/demil/eliminar_producto.php"
        val requestQueue = Volley.newRequestQueue(this)

        val stringRequest = object : StringRequest(
            Method.POST, url,
            Response.Listener { response ->
                // Procesar la respuesta del servidor (puedes mostrar un mensaje de éxito, por ejemplo)
                Toast.makeText(this, response, Toast.LENGTH_SHORT).show()
            },
            Response.ErrorListener { error ->
                // Manejar el error (puedes mostrar un mensaje de error)
                Toast.makeText(this, "Error al eliminar el producto", Toast.LENGTH_SHORT).show()
            }) {

            // Sobrescribir el método getParams para enviar el ID del producto en el cuerpo de la solicitud
            override fun getParams(): Map<String, String> {
                val params = HashMap<String, String>()
                params["idProducto"] = idProducto
                return params
            }
        }

        // Agregar la solicitud a la cola
        requestQueue.add(stringRequest)
    }

}