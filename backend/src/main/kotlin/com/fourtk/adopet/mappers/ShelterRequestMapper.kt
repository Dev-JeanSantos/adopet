package com.fourtk.adopet.mappers

import com.fourtk.adopet.dtos.petpequestsdto.ShelterRequestDTO
import com.fourtk.adopet.models.Shelter
import com.fourtk.adopet.services.TutorService
import org.springframework.stereotype.Component

@Component
class ShelterRequestMapper(
    private val tutorService: TutorService
) : Mapper<ShelterRequestDTO, Shelter> {
    override fun map(t: ShelterRequestDTO): Shelter {
        return Shelter(
            name= t.name,
            cnpj=t.cnpj,
            phone = t.phone,
            email = t.email,
            address = t.address,
            city = t.city,
            uf = t.uf,
            image = t.image,
            responsible = tutorService.getBYId(t.idResponsible)
        )
    }
}