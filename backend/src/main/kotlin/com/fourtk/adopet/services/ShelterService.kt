package com.fourtk.adopet.services

import com.fourtk.adopet.dtos.PetRequestsDTO.ShelterRequestDTO
import com.fourtk.adopet.dtos.ShelterResponseDTO.ShelterResponseDTO
import com.fourtk.adopet.mappers.ShelterRequestMapper
import com.fourtk.adopet.mappers.ShelterResponseMapper
import com.fourtk.adopet.models.Shelter
import com.fourtk.adopet.repositories.ShelterRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ShelterService(
    private val shelterRequestMapper: ShelterRequestMapper,
    private val shelterResponseMapper: ShelterResponseMapper,
    private val shelterRepository: ShelterRepository,
) {
    fun insertShelter(shelterRequestDTO: ShelterRequestDTO): ShelterResponseDTO? {
        val shelter = shelterRequestMapper.map(shelterRequestDTO)
        shelterRepository.save(shelter)
        return shelterResponseMapper.map(shelter)
    }

    fun getBYId(idShelter: Long): Shelter? {
        return shelterRepository.getOne(idShelter)
    }

    fun listar(shelterCity: String?, shelterName: String?, pagination: Pageable): Page<ShelterResponseDTO> {

        val shelters = if (shelterCity == null && shelterName == null) {
            shelterRepository.findAll(pagination)
        } else if (shelterName != null) {
            shelterRepository.findByName(shelterName, pagination)
        } else {
            (shelterCity != null)
            shelterRepository.findByCity(shelterCity, pagination)

        }
        return shelters.map { t ->
            shelterResponseMapper.map(t)
        }
    }

}
