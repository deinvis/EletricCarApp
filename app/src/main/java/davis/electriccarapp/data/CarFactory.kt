package davis.electriccarapp.data

import davis.electriccarapp.domain.Carro
import davis.electriccarapp.R


object CarFactory {
    val list = listOf(
        Carro(
            id = 1,
            preco = "R$300.000,00",
            bateria = "300 kWh",
            potencia = "200cv",
            recarga = "30 min",
            urlPhoto = R.drawable.compact_blue),
        Carro(
            id = 1,
            preco = "R$150.000,00",
            bateria = "160 kWh",
            potencia = "100cv",
            recarga = "60 min",
            urlPhoto = R.drawable.compact_white)
    )
}