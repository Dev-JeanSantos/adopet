package com.fourtk.adopet.dtos.TutorResponsesDTO

data class PetResponseDTO (
        val name: String,
        val idOwner: Long?,
        val nameOwner: String,
        val city: String,
        val uf: String,
        val age: String,
        val status: String,
        val carrying: String,
        val specie:String,
        val personality: String,
        val description:String,
        val image: String?
)
