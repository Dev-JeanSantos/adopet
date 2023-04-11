package com.fourtk.adopet.mappers

import com.fourtk.adopet.dtos.PetResponsesDTO.PetResponseDTO
import com.fourtk.adopet.models.Pet
import org.springframework.stereotype.Component

@Component
class PetResponseMapper: Mapper<Pet, PetResponseDTO> {
    override fun map(t: Pet): PetResponseDTO {
        return PetResponseDTO(
            name= t.name,
            idOwner = t.tutor?.id,
            nameOwner = t.tutor!!.name,
            city = t.tutor!!.city,
            uf = t.tutor!!.uf,
            age = t.age,
            status = t.status.name,
            carrying = t.carrying.name,
            specie = t.specie.name,
            personality = t.personality.name,
            ageMonthOrYear = t.ageMonthOrYear.name,
            description = t.description,
            image = t.image,
            genre = t.genre.name
        )
    }


}