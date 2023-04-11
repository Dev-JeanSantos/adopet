package com.fourtk.adopet.dtos.PetRequestsDTO

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class ShelterRequestDTO (
        @field:NotEmpty
        @field:Size(min = 5, max = 50)
        val name: String,
        @field:NotBlank
        val cnpj: String,
        @field:NotBlank
        val phone: String,
        @field:NotBlank
        val email: String,
        @field:NotNull
        val address: String,
        @field:NotNull
        val city: String,
        @field:NotNull
        val uf: String,
        @field:NotNull
        val image: String? = "",
        @field:NotNull
        val idResponsible: Long,
)
