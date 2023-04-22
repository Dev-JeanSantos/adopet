package com.fourtk.adopet.model

import com.fourtk.adopet.enums.*
import com.fourtk.adopet.models.Pet

object PetTest {
    fun build() = Pet(
        id = 1,
        name = "Lessie",
        age = 10,
        ageMonthOrYear = PetAgeMonthOrYear.YEAR,
        genre = PetGenre.FEMALE,
        status = PetStatus.ADOPTED,
        carrying = PetCarrying.LARGE,
        specie = PetSpecie.DOG,
        personality = PetPersonality.PASSIVE,
        description = "Cadela de quase velhinha mas muito amorosa e obediente",
        image = "www.lessie.com.br",
        shelter = ShelterTeste.build()
    )
}