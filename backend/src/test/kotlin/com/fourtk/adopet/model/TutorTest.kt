package com.fourtk.adopet.model

import com.fourtk.adopet.models.Tutor

object TutorTest {
    fun build() = Tutor(
        id = 1,
        name = "Jean",
        email = "email@email.com.br",
        password = "123456",
        cpf = "1234567879-00",
        address = "Rua A 2009 Centro",
        city = "Rio Bonito",
        uf = "SP",
        phone = "22-99229922",
        image = "imagem.com.br"
    )
}