package com.fourtk.adopet.model

import com.fourtk.adopet.dtos.tutorresponse.TutorResponsePaginationDTO

object TutorResponsePaginationDTOTest {
    fun build() = TutorResponsePaginationDTO(

        name= "Paulo Pedro",
        email= "paulinho@gmail.com",
        address= "Rua Sete de Maio, S/N Vila Madalena",
        city= "Sorocoba",
        uf= "SP",
        phone="12-699667738",
        image=  "www.imagem-1.com.br"
    )
}