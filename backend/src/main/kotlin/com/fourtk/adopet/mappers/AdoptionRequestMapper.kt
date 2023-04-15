package com.fourtk.adopet.mappers

import com.fourtk.adopet.dtos.adoptionrequest.AdoptionRequestDTO
import com.fourtk.adopet.models.Adoption
import com.fourtk.adopet.services.PetService
import com.fourtk.adopet.services.TutorService
import org.springframework.stereotype.Component

@Component
class AdoptionRequestMapper(
    private val tutorService: TutorService,
    private val petService: PetService,
) : Mapper<AdoptionRequestDTO, Adoption> {
    override fun map(t: AdoptionRequestDTO): Adoption {
        return  Adoption(
            tutor = tutorService.getBYId(t.idTutor),
            pet = petService.getByIdPet(t.idPet)!!,
        )
    }
}
