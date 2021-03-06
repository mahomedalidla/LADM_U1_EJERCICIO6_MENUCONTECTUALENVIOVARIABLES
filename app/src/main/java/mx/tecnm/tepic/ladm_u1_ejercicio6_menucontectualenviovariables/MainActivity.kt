package mx.tecnm.tepic.ladm_u1_ejercicio6_menucontectualenviovariables

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.button
import kotlinx.android.synthetic.main.activity_main.numero
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity : AppCompatActivity() {
    val objRegresoValores = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){ result->
        val intentRegresado = result.data
        val extra = intentRegresado!!.extras!!

        var nombre=extra.getString("nombre")
        var mensaje= extra.getString("mensaje")

        textviewmensaje.setText("nombre ${nombre}\nMensaje: ${mensaje}")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            //Contruccion de objeto
            val ventana2 = Intent(this,MainActivity2::class.java)
            //agregando extras
            ventana2.putExtra("identificador-numeral",numero.text.toString().toInt())

            //startActivity(ventana2)
            objRegresoValores.launch(ventana2)

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflaterOB = menuInflater

        inflaterOB.inflate(R.menu.principal,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.acerca->{
                AlertDialog.Builder(this)
                    .setTitle("Acerca de:")
                    .setMessage("Mahomedalid.")
                    .show()
            }
            R.id.salir->{
                finish()
            }
            R.id.prueba->{
                Toast.makeText(this,"Texto",Toast.LENGTH_LONG).show()
            }
        }
        return true
    }
}