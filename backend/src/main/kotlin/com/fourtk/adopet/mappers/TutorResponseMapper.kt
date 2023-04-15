package com.fourtk.adopet.mappers

import com.fourtk.adopet.dtos.tutorresponse.TutorResponseDTO
import com.fourtk.adopet.models.Tutor
import org.springframework.stereotype.Component

@Component
class TutorResponseMapper: Mapper<Tutor, TutorResponseDTO> {
    override fun map(t: Tutor): TutorResponseDTO {
        return TutorResponseDTO(
                name = t.name,
                email = t.email
        )
    }


}