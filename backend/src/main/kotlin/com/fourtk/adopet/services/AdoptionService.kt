package com.fourtk.adopet.services

import com.fourtk.adopet.dtos.adoptionrequest.AdoptionRequestDTO
import com.fourtk.adopet.dtos.adoptionresponse.AdoptionResponseDTO
import com.fourtk.adopet.enums.PetStatus
import com.fourtk.adopet.exceptions.NotFoundException
import com.fourtk.adopet.mappers.AdoptionRequestMapper
import com.fourtk.adopet.mappers.AdoptionResponseMapper
import com.fourtk.adopet.repositories.AdoptionRepository
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class AdoptionService(
    private val adoptionRequestMapper: AdoptionRequestMapper,
    private val adoptionResponseMapper: AdoptionResponseMapper,
    private val adoptionRepository: AdoptionRepository,
    private val petService: PetService,
    val notFoundException: String = "Pet not found!"
) {

    private val logger = LoggerFactory.getLogger(this::class.java)
    fun insertAdoption(adoptionRequestDTO: AdoptionRequestDTO): AdoptionResponseDTO? {
        logger.info("Start insertAdoption, new adoption:${adoptionRequestDTO}- Service")
        petService.updateStatus(adoptionRequestDTO.idPet, status = PetStatus.ADOPTED)
        val adoption = adoptionRequestMapper.map(adoptionRequestDTO)
            adoptionRepository.save(adoption)
        logger.info("End insertAdoption of Success - Service")
            return adoptionResponseMapper.map(adoption)
    }


    fun listAllAdoptions(pagination: Pageable): Page<AdoptionResponseDTO> {
        logger.info("Start listAllAdoptions - Service")
        val adoptions = adoptionRepository.findAll(pagination)
        logger.info("End listAllAdoptions - Service")
        return adoptions.map { t ->
            adoptionResponseMapper.map(t)
        }
    }

    fun getById(id: Long): AdoptionResponseDTO {
        try {
            logger.info("Start getById - Service")
            logger.info("validating if the adoption exists com idAdoption:${id} - Service")
            val possiblePet = adoptionRepository.findById(id).orElseThrow { NotFoundException(notFoundException) }
            logger.info("End getById - Service")
            return adoptionResponseMapper.map(possiblePet)
        }catch (e:Exception){
            throw e
        }
    }
    fun delete(id: Long) {
        logger.info("Start delete - Service")
        logger.info("End delete - Service")
        return adoptionRepository.deleteById(id)
    }

}
