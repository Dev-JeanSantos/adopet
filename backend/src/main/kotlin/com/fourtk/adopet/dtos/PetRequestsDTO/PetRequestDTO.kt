package com.fourtk.adopet.dtos.PetRequestsDTO

import com.fourtk.adopet.enums.*
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive
import jakarta.validation.constraints.Size

data class PetRequestDTO (
        @field:NotEmpty
        @field:Size(min = 5, max = 50)
        val name: String,
        @field:NotNull
        val idOwner: Long,
        @field:NotNull
        @field:Positive
        val age: Int,
        @field:NotNull
        val ageMonthOrYear: PetAgeMonthOrYear,
        @field:NotNull
        val status: PetStatus,
        @field:NotNull
        val genre: PetGenre,
        @field:NotNull
        val carrying: PetCarrying,
        @field:NotNull
        val specie: PetSpecie,
        @field:NotNull
        val personality: PetPersonality,
        @field:NotEmpty
        val description: String,
        val image: String? = "",
)
