package com.fourtk.adopet.model

import com.fourtk.adopet.models.Shelter

object ShelterTeste {
    fun build() = Shelter(
        id = 1,
        name = "Canil A",
        cnpj = "000000000/0001-00",
        phone = "022-27472478",
        email = "canila@email.com",
        address = "Rua A, 200 Centro",
        city = "Rio Bonito",
        uf = "RJ",
        image = "canila.com.br"
    )
}
