package davis.electriccarapp.presentation

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import davis.electriccarapp.R

class AutonomiaActivity : AppCompatActivity(){
    lateinit var bt_calcular: Button
    lateinit var et_preco: EditText
    lateinit var et_kmPercorrido:EditText
    lateinit var tv_resultado:TextView
    lateinit var iv_close:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_autonomia)
        setupViews()
        setupListeners()
    }

    fun setupViews(){
        bt_calcular = findViewById(R.id.bt_calcular)
        et_preco = findViewById(R.id.et_preco_kwh)
        et_kmPercorrido = findViewById(R.id.et_km_percorrido)
        tv_resultado = findViewById(R.id.tv_resultado)
        iv_close = findViewById(R.id.iv_close)
    }

    fun setupListeners(){
        bt_calcular.setOnClickListener{
            val resultado = et_preco.text.toString().toFloat() * et_kmPercorrido.text.toString().toFloat()
            tv_resultado.text = resultado.toString()
            tv_resultado.visibility = View.VISIBLE
        }
        iv_close.setOnClickListener{
            finish()
        }
    }
}