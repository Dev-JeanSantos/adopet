package com.fourtk.adopet.dtos.petrequest

import javax.validation.constraints.*

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
