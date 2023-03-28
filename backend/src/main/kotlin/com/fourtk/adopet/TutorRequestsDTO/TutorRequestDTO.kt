package com.fourtk.adopet.TutorRequestsDTO

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
        val password: String
)
