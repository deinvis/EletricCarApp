package davis.electriccarapp.data

import davis.electriccarapp.domain.Carro


object CarFactory {
    var list = listOf(
        Carro(
            id = 1,
            preco = "R$300.000,00",
            bateria = "300 kWh",
            potencia = "200cv",
            recarga = "30 min",
            urlPhoto = "a"),
        Carro(
            id = 2,
            preco = "R$150.000,00",
            bateria = "160 kWh",
            potencia = "100cv",
            recarga = "60 min",
            urlPhoto = "a"
    ))
}