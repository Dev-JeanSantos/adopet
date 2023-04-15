package com.fourtk.adopet.mappers

import com.fourtk.adopet.dtos.shelterresponsedto.ShelterResponseDTO
import com.fourtk.adopet.models.Shelter
import org.springframework.stereotype.Component

@Component
class ShelterResponseMapper: Mapper<Shelter, ShelterResponseDTO> {
    override fun map(t: Shelter): ShelterResponseDTO {
        return ShelterResponseDTO(
            name= t.name,
            cnpj=t.cnpj,
            phone = t.phone,
            email= t.email,
            address= t.address,
            city=t.city,
            uf=t.uf,
            image = t.image,
            nameResponsible =  t.responsible!!.name
        )
    }
}