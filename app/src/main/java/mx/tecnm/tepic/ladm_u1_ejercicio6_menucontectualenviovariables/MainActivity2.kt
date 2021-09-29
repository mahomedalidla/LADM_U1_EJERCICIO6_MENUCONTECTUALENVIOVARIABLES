package mx.tecnm.tepic.ladm_u1_ejercicio6_menucontectualenviovariables

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var extra = intent.extras!!

        var numeroObtenido = extra.getInt("identificador-numeral")

        textview2.setText("Valor desde activiti 1 ${numeroObtenido}")

        button.setOnClickListener {
            val intentRegresar = Intent()

            intentRegresar.putExtra("nombre","Maho")
            intentRegresar.putExtra("mensaje","buenos dias, hola como estas")

            setResult(0,intentRegresar)

            finish()//regresar al activiti que lo llamo
        }
    }
}