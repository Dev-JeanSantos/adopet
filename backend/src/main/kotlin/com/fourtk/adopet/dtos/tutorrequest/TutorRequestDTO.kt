package com.fourtk.adopet.dtos.tutorrequest

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

data class TutorRequestDTO (
        @field:NotEmpty
        @field:Size(min = 5, max = 50)
        val name: String,
        @field:NotEmpty
        @field:Email
        val email: String,
        @field:NotEmpty
        val password: String,
        @field:NotEmpty
        val cpf: String,
        @field:NotEmpty
        val address: String,
        @field:NotEmpty
        val city: String,
        @field:NotEmpty
        val uf: String,
        @field:NotEmpty
        val phone: String,
        val image: String? = ""
)
