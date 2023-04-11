package com.fourtk.adopet.mappers

import com.fourtk.adopet.dtos.TutorResponsesDTO.TutorResponsePaginationDTO
import com.fourtk.adopet.models.Tutor
import org.springframework.stereotype.Component

@Component
class TutorResponsePaginationMapper : Mapper<Tutor, TutorResponsePaginationDTO> {
    override fun map(t: Tutor): TutorResponsePaginationDTO {
        return TutorResponsePaginationDTO(
            name = t.name,
            email = t.email,
            city = t.city,
            address = t.address,
            uf = t.uf,
            image = t.image,
            phone = t.phone,
        )
    }


}