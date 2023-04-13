package com.fourtk.adopet.dtos.PetResponsesDTO

data class PetResponseDTO (
        val name: String,
        val idShelter: Long?,
        val nameShelter: String,
        val nameOwnerShelter: String,
        val specie:String,
        val age: Int,
        val ageMonthOrYear: String,
        val genre: String,
        val carrying: String,
        val personality: String,
        val status: String,
        val description:String,
        val image: String?,
        val city: String,
        val uf: String,
)
