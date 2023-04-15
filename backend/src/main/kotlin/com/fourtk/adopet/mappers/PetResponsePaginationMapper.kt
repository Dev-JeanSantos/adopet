package com.fourtk.adopet.mappers

import com.fourtk.adopet.dtos.petresponse.PetResponsePaginationDTO
import com.fourtk.adopet.models.Pet
import org.springframework.stereotype.Component

@Component
class PetResponsePaginationMapper : Mapper<Pet, PetResponsePaginationDTO> {
    override fun map(t: Pet): PetResponsePaginationDTO {
        return PetResponsePaginationDTO(
            name= t.name,
            nameShelter = t.shelter!!.name,
            nameOwnerShelter = t.shelter?.responsible!!.name,
            city = t.shelter!!.city,
            uf = t.shelter!!.uf,
            status = t.status.name,
            specie = t.specie.name,
            image = t.image,
            genre = t.genre.name
        )
    }


}