package com.fourtk.adopet.mappers

import com.fourtk.adopet.dtos.TutorResponsesDTO.PetResponseDTO
import com.fourtk.adopet.dtos.TutorResponsesDTO.TutorResponseDTO
import com.fourtk.adopet.models.Pet
import com.fourtk.adopet.models.Tutor
import org.springframework.stereotype.Component

@Component
class PetResponseMapper: Mapper<Pet, PetResponseDTO> {
    override fun map(t: Pet): PetResponseDTO {
        return PetResponseDTO(
            name= t.name,
            idOwner = t.idOwner,
            age = t.age,
            status = t.status.name,
            carrying = t.carrying.name,
            specie = t.specie.name,
            personality = t.personality.name,
            description = t.description,
            image = t.image
        )
    }


}