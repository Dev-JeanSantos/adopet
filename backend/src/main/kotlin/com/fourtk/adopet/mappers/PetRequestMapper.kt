package com.fourtk.adopet.mappers

import com.fourtk.adopet.dtos.TutorRequestsDTO.PetRequestDTO
import com.fourtk.adopet.models.Pet
import org.springframework.stereotype.Component

@Component
class PetRequestMapper : Mapper<PetRequestDTO, Pet> {
    override fun map(t: PetRequestDTO): Pet {
        return Pet(
            name= t.name,
            idOwner = t.idOwner,
            age = t.age,
            status = t.status,
            carrying = t.carrying,
            specie = t.specie,
            personality = t.personality,
            description = t.description,
            image = t.image
        )
    }
}