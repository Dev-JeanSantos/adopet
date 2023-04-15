package com.fourtk.adopet.services

import com.fourtk.adopet.dtos.adoptionrequest.AdoptionRequestDTO
import com.fourtk.adopet.dtos.adoptionresponse.AdoptionResponseDTO
import com.fourtk.adopet.dtos.petrequest.PetRequestDTO
import com.fourtk.adopet.dtos.petresponse.PetResponseDTO
import com.fourtk.adopet.mappers.*
import com.fourtk.adopet.models.Adoption
import com.fourtk.adopet.repositories.AdoptionRepository
import com.fourtk.adopet.repositories.PetRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class AdoptionService(
    private val adoptionRequestMapper: AdoptionRequestMapper,
    private val adoptionResponseMapper: AdoptionResponseMapper,
    private val adoptionRepository: AdoptionRepository,

    private val tutorService: TutorService,

    val notFoundException: String = "Pet not found!"
) {

    private val logger = LoggerFactory.getLogger(this::class.java)
    fun insertAdoption(adoptionRequestDTO: AdoptionRequestDTO): AdoptionResponseDTO? {
        logger.info("Start insertAdoption, new adoption:${adoptionRequestDTO}- Service")
        val adoption = adoptionRequestMapper.map(adoptionRequestDTO)
            adoptionRepository.save(adoption)
        logger.info("End insertAdoption of Success - Service")
            return adoptionResponseMapper.map(adoption)
    }


//    fun listar(petName: String?, petCity: String?, pagination: Pageable): Page<PetResponsePaginationDTO> {
//
//
//        val pets = if (petName == null && petCity == null) {
//            petRepository.findAll(pagination)
//        } else if (petName != null) {
//            petRepository.findByName(petName, pagination)
//        } else {
//            (petCity != null)
//            petRepository.findByShelterCity(petCity, pagination)
//
//        }
//        return pets.map { t ->
//            petResponsePaginationMapper.map(t)
//        }
//
//    }
//
//    fun getById(id: Long): PetResponseDTO {
//        val possiblePet = petRepository.findById(id).orElseThrow { NotFoundException(notFoundException) }
//        return petResponseMapper.map(possiblePet)
//    }
//
//    fun update(id: Long, petRequestDTO: PetRequestDTO): PetResponseDTO? {
//
//        val pet = petRepository.findById(id).orElseThrow() {
//            NotFoundException(notFoundException)
//        }
//        pet.shelter = shelterService.getBYId(petRequestDTO.idShelter!!)
//        pet.name = petRequestDTO.name
//        pet.age = petRequestDTO.age
//        pet.ageMonthOrYear = petRequestDTO.ageMonthOrYear
//        pet.status = petRequestDTO.status
//        pet.genre = petRequestDTO.genre
//        pet.carrying = petRequestDTO.carrying
//        pet.specie = petRequestDTO.specie
//        pet.personality = petRequestDTO.personality
//        pet.description = petRequestDTO.description
//        pet.image = petRequestDTO.image
//
//        return petResponseMapper.map(pet)
//
//    }
//
//    fun delete(id: Long) {
//        val pet = petRepository.deleteById(id)
//    }

}
