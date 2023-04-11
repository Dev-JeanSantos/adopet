package com.fourtk.adopet.mappers

import com.fourtk.adopet.dtos.PetRequestsDTO.PetRequestDTO
import com.fourtk.adopet.models.Pet
import com.fourtk.adopet.services.TutorService
import org.springframework.stereotype.Component

@Component
class PetRequestMapper(
    private val tutorService: TutorService
) : Mapper<PetRequestDTO, Pet> {
    override fun map(t: PetRequestDTO): Pet {
        return Pet(
            name= t.name,
            age = t.age,
            status = t.status,
            carrying = t.carrying,
            specie = t.specie,
            ageMonthOrYear = t.ageMonthOrYear,
            personality = t.personality,
            description = t.description,
            image = t.image,
            tutor = tutorService.getBYId(t.idOwner),
            genre = t.genre,
        )
    }
}