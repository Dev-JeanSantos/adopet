package com.fourtk.adopet.mappers

import com.fourtk.adopet.dtos.PetResponsesDTO.PetResponsePaginationDTO
import com.fourtk.adopet.models.Pet
import org.springframework.stereotype.Component

@Component
class PetResponsePaginationMapper : Mapper<Pet, PetResponsePaginationDTO> {
    override fun map(t: Pet): PetResponsePaginationDTO {
        return PetResponsePaginationDTO(
            name= t.name,
            nameOwner = t.tutor.name,
            city = t.tutor.city,
            uf = t.tutor.uf,
            status = t.status.name,
            specie = t.specie.name,
            image = t.image,
            genre = t.genre.name
        )
    }


}