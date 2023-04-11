package com.fourtk.adopet.services

import com.fourtk.adopet.dtos.PetRequestsDTO.PetRequestDTO
import com.fourtk.adopet.dtos.PetResponsesDTO.PetResponseDTO
import com.fourtk.adopet.dtos.PetResponsesDTO.PetResponsePaginationDTO
import com.fourtk.adopet.exceptions.NotFoundException
import com.fourtk.adopet.mappers.*
import com.fourtk.adopet.repositories.PetRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class PetService(
    private val petRequestMapper: PetRequestMapper,
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
            petRepository.findByTutorCity(petCity, pagination)

        }
        return pets.map { t ->
            petResponsePaginationMapper.map(t)
        }
        println(petName)

    }

    fun getById(id: Long): PetResponseDTO {
        val possiblePet = petRepository.findById(id).
                orElseThrow{ NotFoundException(notFoundException) }
        return petResponseMapper.map(possiblePet)
    }


//    fun getById(id: Long): TutorResponsePaginationDTO {
//
//
//    }
//
//    fun update(id: Long, tutorRequestUpdateDTO: TutorRequestDTO): TutorResponseDTO? {
//        val tutor = tutorRepository.findById(id).orElseThrow(){
//            NotFoundException(notFoundException)
//        }
//        println(tutor)
//        tutor.name = tutorRequestUpdateDTO.name
//        tutor.email = tutorRequestUpdateDTO.email
//        tutor.cpf = tutorRequestUpdateDTO.cpf
//        tutor.address = tutorRequestUpdateDTO.address
//        tutor.city = tutorRequestUpdateDTO.city
//        tutor.uf = tutorRequestUpdateDTO.uf
//        tutor.phone = tutorRequestUpdateDTO.phone
//        tutor.password = tutorRequestUpdateDTO.password
//        tutor.image = tutorRequestUpdateDTO.image
//
//        return tutorResponseMapper.map(tutor)
//    }
//
//    fun delete(id: Long) {
//        val tutor = tutorRepository.deleteById(id)
//    }
}
