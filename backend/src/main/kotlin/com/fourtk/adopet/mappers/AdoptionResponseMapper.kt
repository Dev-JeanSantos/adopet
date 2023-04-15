package com.fourtk.adopet.mappers

import com.fourtk.adopet.dtos.adoptionresponse.AdoptionResponseDTO
import com.fourtk.adopet.models.Adoption
import org.springframework.stereotype.Component

@Component
class AdoptionResponseMapper(
) : Mapper<Adoption, AdoptionResponseDTO> {
    override fun map(t: Adoption): AdoptionResponseDTO {
        return AdoptionResponseDTO(
            nameTutor = t.tutor.name,
            phoneTutor = t.tutor.phone,
            imageTutor = t.tutor.image,
            city = t.tutor.city,
            uf = t.tutor.uf,
            namePet = t.pet.name,
            nameShelter = t.pet.shelter!!.name,
            specie = t.pet.specie.name,
            age = t.pet.age,
            ageMonthOrYear = t.pet.ageMonthOrYear.name,
            genre = t.pet.genre.name,
            carrying = t.pet.carrying.name,
            personality = t.pet.personality.name,
            status = t.pet.status.name,
            descriptionPet = t.pet.description,
            imagePet = t.pet.image
        )
    }

}
