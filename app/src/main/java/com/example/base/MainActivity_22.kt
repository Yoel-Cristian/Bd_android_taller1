package com.example.base


















import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.base.Ip

class MainActivity_22 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var conectar2=findViewById<Button>(R.id.conexion)
        var ip_c=findViewById<EditText>(R.id.ip_conexion)

        conectar2.setOnClickListener{
            Ip.ip=ip_c.text.toString()
            ip_c.setText("")

            val toast = Toast.makeText(this, "Se conecto correctamente al Servidor: ${Ip.ip}", Toast.LENGTH_SHORT)
            toast.show()

            Handler(Looper.getMainLooper()).postDelayed({
                toast.cancel()
            }, 2000)
        }


    }


    fun onButtonClick(view: View) {
        val intent: Intent = when (view.id) {
            R.id.usuario -> {
                Intent(this, Producto::class.java).apply {
                    putExtra("opcion", "Cliente")
                }
            }
            R.id.adm -> {
                Intent(this, personal::class.java).apply {
                    putExtra("opcion", "personal")
                }
            }
            else -> throw IllegalArgumentException("ID de vista desconocido")
        }
        startActivity(intent)
    }



}