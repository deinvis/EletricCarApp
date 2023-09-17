package davis.electriccarapp.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import davis.electriccarapp.R
import davis.electriccarapp.presentation.adapter.CarAdapter

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
        val dados = arrayOf(
            "Cupcake", "Donut", "Froyo", "Gingerbread", "Honeycomb",
            "Ice Cream Sandwich", "Jelly Bean"
        )
        val adapter = CarAdapter(dados)
        listaCarros.layoutManager = LinearLayoutManager(this)
        listaCarros.adapter = adapter
    }

    private fun setupListeners() {
        button.setOnClickListener {
            startActivity(Intent(this, AutonomiaActivity::class.java))
        }
    }
}