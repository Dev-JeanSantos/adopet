package com.fourtk.adopet.mappers

import com.fourtk.adopet.models.Tutor
import com.fourtk.adopet.TutorRequestsDTO.TutorRequestDTO
import org.springframework.stereotype.Component

@Component
class TutorRequestMapper : Mapper<TutorRequestDTO, Tutor> {
    override fun map(t: TutorRequestDTO): Tutor {
        return Tutor(
            name = t.name,
            email = t.email,
            password = t.password,
            cpf = t.cpf,
            address = t.address,
            city = t.city,
            uf = t.uf,
            phone = t.phone,
            image = t.image
        )
    }
}