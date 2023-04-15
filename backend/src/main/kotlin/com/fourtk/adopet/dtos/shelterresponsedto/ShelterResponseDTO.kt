package com.fourtk.adopet.dtos.shelterresponsedto

data class ShelterResponseDTO (
        val name: String,
        val cnpj: String,
        val phone: String,
        val email: String,
        val address: String,
        val city: String,
        val uf: String,
        val image: String? = "",
        val nameResponsible: String,
)
