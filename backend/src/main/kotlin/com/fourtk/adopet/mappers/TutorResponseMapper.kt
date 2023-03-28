package com.fourtk.adopet.mappers

import com.fourtk.adopet.TutorResponsesDTO.TutorResponseDTO
import com.fourtk.adopet.models.Tutor
import org.springframework.stereotype.Component

@Component
class TutorResponseMapper: Mapper<Tutor, TutorResponseDTO> {
    override fun map(t: Tutor): TutorResponseDTO {
        return TutorResponseDTO(
                id = t.id,
                name = t.name,
                email = t.email
        )
    }


}