package com.fourtk.adopet.services

import com.fourtk.adopet.dtos.petrequest.PetRequestDTO
import com.fourtk.adopet.dtos.petresponse.PetResponseDTO
import com.fourtk.adopet.dtos.petresponse.PetResponsePaginationDTO
import com.fourtk.adopet.exceptions.NotFoundException
import com.fourtk.adopet.mappers.PetRequestMapper
import com.fourtk.adopet.mappers.PetResponseMapper
import com.fourtk.adopet.mappers.PetResponsePaginationMapper
import com.fourtk.adopet.models.Pet
import com.fourtk.adopet.repositories.PetRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class PetService(
    private val petRequestMapper: PetRequestMapper,
    private val shelterService: ShelterService,
    private val petResponseMapper: PetResponseMapper,
    private val petResponsePaginationMapper: PetResponsePaginationMapper,
    private val petRepository: PetRepository,

    val notFoundException: String = "Pet not found!"
) {
    fun insertPet(petRequestDTO: PetRequestDTO): PetResponseDTO {
        val pet = petRequestMapper.map(petRequestDTO)
        petRepository.save(pet)
        return petResponseMapper.map(pet)
    }

    fun listar(petName: String?, petCity: String?, pagination: Pageable): Page<PetResponsePaginationDTO> {


        val pets = if (petName == null && petCity == null) {
            petRepository.findAll(pagination)
        } else if (petName != null) {
            petRepository.findByName(petName, pagination)
        } else {
            (petCity != null)
            petRepository.findByShelterCity(petCity, pagination)

        }
        return pets.map { t ->
            petResponsePaginationMapper.map(t)
        }

    }

    fun getById(id: Long): PetResponseDTO {
        val possiblePet = petRepository.findById(id).orElseThrow { NotFoundException(notFoundException) }
        return petResponseMapper.map(possiblePet)
    }

    fun update(id: Long, petRequestDTO: PetRequestDTO): PetResponseDTO? {

        val pet = petRepository.findById(id).orElseThrow() {
            NotFoundException(notFoundException)
        }
        pet.shelter = shelterService.getBYId(petRequestDTO.idShelter!!)
        pet.name = petRequestDTO.name
        pet.age = petRequestDTO.age
        pet.ageMonthOrYear = petRequestDTO.ageMonthOrYear
        pet.status = petRequestDTO.status
        pet.genre = petRequestDTO.genre
        pet.carrying = petRequestDTO.carrying
        pet.specie = petRequestDTO.specie
        pet.personality = petRequestDTO.personality
        pet.description = petRequestDTO.description
        pet.image = petRequestDTO.image

        return petResponseMapper.map(pet)

    }

    fun delete(id: Long) {
        val pet = petRepository.deleteById(id)
    }

    fun getByIdPet(id: Long): Pet? {
        return petRepository.findByIdOrNull(id)
    }
}
