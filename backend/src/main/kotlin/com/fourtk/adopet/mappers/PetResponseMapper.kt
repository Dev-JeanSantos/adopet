package com.fourtk.adopet.mappers

import com.fourtk.adopet.dtos.PetResponsesDTO.PetResponseDTO
import com.fourtk.adopet.models.Pet
import org.springframework.stereotype.Component

@Component
class PetResponseMapper: Mapper<Pet, PetResponseDTO> {
    override fun map(t: Pet): PetResponseDTO {
        return PetResponseDTO(
            name= t.name,
            city = t.shelter!!.city,
            uf = t.shelter!!.uf,
            nameOwnerShelter=t.shelter?.responsible!!.name,
            age = t.age,
            status = t.status.name,
            carrying = t.carrying.name,
            specie = t.specie.name,
            personality = t.personality.name,
            ageMonthOrYear = t.ageMonthOrYear.name,
            description = t.description,
            image = t.image,
            genre = t.genre.name,
            idShelter = t.shelter!!.id,
            nameShelter = t.shelter!!.name
        )
    }
}