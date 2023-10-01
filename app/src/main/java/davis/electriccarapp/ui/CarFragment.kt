package davis.electriccarapp.ui

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import davis.electriccarapp.R
import davis.electriccarapp.data.CarFactory
import davis.electriccarapp.domain.Carro
import davis.electriccarapp.ui.adapter.CarAdapter
import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONTokener
import java.net.HttpURLConnection
import java.net.URL

class CarFragment : Fragment() {
    lateinit var listaCarros: RecyclerView
    lateinit var fabCalcular: FloatingActionButton
    var carrosArray: ArrayList<Carro> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.car_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        callService()
        setupViews(view)
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
    private fun setupList() {
        val adapter = CarAdapter(carrosArray)
        listaCarros.adapter = adapter
    }

    fun callService(){
        MyTask().execute("https://raw.githubusercontent.com/deinvis/cars-api/main/cars.json")
    }

    inner class MyTask : AsyncTask<String, String, String>() {

        override fun onPreExecute() {
            super.onPreExecute()
            Log.d("MyTask", "Iniciando...")
        }

        override fun doInBackground(vararg url: String?): String {
            var urlConnection: HttpURLConnection? = null
            try {
                val urlBase = URL(url[0])
                urlConnection = urlBase.openConnection() as HttpURLConnection
                urlConnection.connectTimeout = 60000
                urlConnection.readTimeout = 60000
                urlConnection.setRequestProperty(
                    "Accept",
                    "application/json"
                )
                val respondeCode = urlConnection.responseCode
                if(respondeCode == HttpURLConnection.HTTP_OK) {
                    var response = urlConnection.inputStream.bufferedReader().use { it.readText() }
                    publishProgress(response)
                }
                else {
                    Log.e("Erro", "Serviço indispnível no momento")
                }
            } catch (ex: Exception) {
                Log.e("Erro", "Erro ao realizar processamento...")
            } finally {
                urlConnection?.disconnect()
            }
            return " "
        }

        override fun onProgressUpdate(vararg values: String?) {
            Log.d("PASSOU AQUI", "0")
            try {
                val jsonArray = JSONTokener(values[0]).nextValue() as JSONArray
                for (i in 0 until jsonArray.length()) {
                    val id = jsonArray.getJSONObject(i).getString("id")
                    Log.d("ID ->", id)
                    val preco = jsonArray.getJSONObject(i).getString("preco")
                    Log.d("PRECO ->", id)
                    val bateria = jsonArray.getJSONObject(i).getString("bateria")
                    Log.d("BATERIA ->", id)
                    val potencia = jsonArray.getJSONObject(i).getString("potencia")
                    Log.d("POTENCIA ->", id)
                    val recarga = jsonArray.getJSONObject(i).getString("recarga")
                    Log.d("RECARGA ->", id)
                    val urlPhoto = jsonArray.getJSONObject(i).getString("urlPhoto")
                    Log.d("RECARGA ->", id)

                    val model = Carro(
                        id = id.toInt(),
                        preco = preco,
                        bateria = bateria,
                        potencia = potencia,
                        recarga = recarga,
                        urlPhoto = urlPhoto
                    )
                    carrosArray.add(model)
                }
                setupList()
            } catch (ex: java.lang.Exception) {
                Log.e("Erro aqui ->", ex.message.toString())
            }
        }
    }
}