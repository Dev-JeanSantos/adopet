package com.fourtk.adopet.services

import com.fourtk.adopet.dtos.PetRequestsDTO.ShelterRequestDTO
import com.fourtk.adopet.dtos.ShelterResponseDTO.ResponsibleShelterResponseDTO
import com.fourtk.adopet.dtos.ShelterResponseDTO.ShelterResponseDTO
import com.fourtk.adopet.exceptions.NotFoundException
import com.fourtk.adopet.mappers.ShelterRequestMapper
import com.fourtk.adopet.mappers.ShelterResponseMapper
import com.fourtk.adopet.models.Shelter
import com.fourtk.adopet.repositories.ShelterRepository
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ShelterService(
    private val shelterRequestMapper: ShelterRequestMapper,
    private val shelterResponseMapper: ShelterResponseMapper,
    private val shelterRepository: ShelterRepository,
    private val notFoundMessage: String = "Shelter not found!",
) {

    private val logger = LoggerFactory.getLogger(this::class.java)
    fun insertShelter(shelterRequestDTO: ShelterRequestDTO): ShelterResponseDTO? {

        logger.info("Start insertPet - Service")

        val shelter = shelterRequestMapper.map(shelterRequestDTO)
        shelterRepository.save(shelter)
        return shelterResponseMapper.map(shelter)
    }

    fun getBYId(idShelter: Long): Shelter? {
        return shelterRepository.findByIdOrNull(idShelter)
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

    fun relatorio():List<ResponsibleShelterResponseDTO> {
        return shelterRepository.relatorio()
    }

    fun findShelterById(idShelter: Long): ShelterResponseDTO {
        logger.info("Start findShelterByID idShelter:${idShelter} - Service")
        logger.info("validating if the shelter exists com idShelter:${idShelter} - Service")
        val possibleShelter = shelterRepository.findById(idShelter).orElseThrow { NotFoundException(notFoundMessage) }
        logger.info("End findShelterByID - Service")
        return shelterResponseMapper.map(possibleShelter)
    }

//    fun getShelterWithPetById(idShelter: Long): ShelterWithPetResponseDTO {
//
//        val possibleShelder = shelterRepository.findById(idShelter).orElseThrow{
//
//            NotFoundException(notFoundMessage)
//        }
//        return ShelterWithPetResponseDTO(possibleShelder)
//
//    }

}
