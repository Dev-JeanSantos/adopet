package com.fourtk.adopet.services

import com.fourtk.adopet.dtos.PetRequestsDTO.ShelterRequestDTO
import com.fourtk.adopet.dtos.ShelterResponseDTO.ShelterResponseDTO
import com.fourtk.adopet.mappers.ShelterRequestMapper
import com.fourtk.adopet.mappers.ShelterResponseMapper
import com.fourtk.adopet.models.Shelter
import com.fourtk.adopet.repositories.ShelterRepository
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

}
