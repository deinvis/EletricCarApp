package davis.electriccarapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import davis.electriccarapp.R
import davis.electriccarapp.data.CarFactory
import davis.electriccarapp.ui.adapter.CarAdapter

class MainActivity : AppCompatActivity() {
    lateinit var button: Button
    lateinit var listaCarros: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViews()
        setupListeners()
    }

    private fun setupViews() {
        button = findViewById(R.id.bt_autonomia)
        listaCarros = findViewById(R.id.rv_informacoes)
        setupLista()
    }

    private fun setupLista() {
        val dados = CarFactory.list
        val adapter = CarAdapter(dados)
        listaCarros.adapter = adapter
    }

    private fun setupListeners() {
        button.setOnClickListener {
            startActivity(Intent(this, AutonomiaActivity::class.java))
        }
    }
}