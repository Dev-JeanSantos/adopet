package com.fourtk.adopet.dtos.petrequest

import com.fourtk.adopet.enums.*
import javax.validation.constraints.*

data class PetRequestDTO (
        @field:NotEmpty
        @field:Size(min = 3, max = 50)
        val name: String,
        val idShelter: Long?,
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
