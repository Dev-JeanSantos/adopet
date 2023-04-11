package com.fourtk.adopet.dtos.PetResponsesDTO

data class PetResponsePaginationDTO (
        val name: String,
        val nameOwner: String,
        val specie:String,
        val genre: String,
        val status: String,
        val image: String?,
        val city: String,
        val uf: String,
)
