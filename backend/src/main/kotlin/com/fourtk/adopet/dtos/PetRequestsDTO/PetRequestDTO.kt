package com.fourtk.adopet.dtos.TutorRequestsDTO

import com.fourtk.adopet.enums.PetCarrying
import com.fourtk.adopet.enums.PetPersonality
import com.fourtk.adopet.enums.PetSpecie
import com.fourtk.adopet.enums.PetStatus
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class PetRequestDTO (
        @field:NotEmpty
        @field:Size(min = 5, max = 50)
        val name: String,
        @field:NotNull
        val idOwner: Long,
        @field:NotEmpty
        val age: String,
        @field:NotNull
        val status: PetStatus,
        @field:NotNull
        val carrying: PetCarrying,
        @field:NotNull
        val specie: PetSpecie,
        @field:NotNull
        val personality: PetPersonality,
        @field:NotEmpty
        val description: String,
        val image: String? = ""
)
