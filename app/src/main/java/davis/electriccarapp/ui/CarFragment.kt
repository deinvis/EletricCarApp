package davis.electriccarapp.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import davis.electriccarapp.R
import davis.electriccarapp.data.CarFactory
import davis.electriccarapp.ui.adapter.CarAdapter

class CarFragment : Fragment() {
    lateinit var listaCarros: RecyclerView
    lateinit var fabCalcular: FloatingActionButton
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.car_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews(view)
        setupLista()
        setupListeners()
    }
    private fun setupViews(view: View) {
        view.apply {
            fabCalcular = findViewById(R.id.fab_calcular)
            listaCarros = findViewById(R.id.rv_informacoes)
        }
    }
    private fun setupListeners() {
        fabCalcular.setOnClickListener {
            startActivity(Intent(context, AutonomiaActivity::class.java))
        }
    }
    private fun setupLista() {
        val dados = CarFactory.list
        val adapter = CarAdapter(dados)
        listaCarros.adapter = adapter
    }
}