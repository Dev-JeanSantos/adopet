package com.fourtk.adopet.services

import com.fourtk.adopet.dtos.TutorRequestsDTO.PetRequestDTO
import com.fourtk.adopet.dtos.TutorRequestsDTO.TutorRequestDTO
import com.fourtk.adopet.dtos.TutorResponsesDTO.PetResponseDTO
import com.fourtk.adopet.dtos.TutorResponsesDTO.TutorResponseDTO
import com.fourtk.adopet.dtos.TutorResponsesDTO.TutorResponsePaginationDTO
import com.fourtk.adopet.exceptions.NotFoundException
import com.fourtk.adopet.mappers.*
import com.fourtk.adopet.repositories.PetRepository
import com.fourtk.adopet.repositories.TutorRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class PetService(
    private val petRequestMapper: PetRequestMapper,
    private val petResponseMapper: PetResponseMapper,
    private val tutorResponsePaginationMapper: TutorResponsePaginationMapper,
    private val petRepository: PetRepository,

    val notFoundException: String = "Tutor not found!"
) {
    fun insertPet(petRequestDTO: PetRequestDTO): PetResponseDTO {
        val pet = petRequestMapper.map(petRequestDTO)
        petRepository.save(pet)
        return petResponseMapper.map(pet)
    }

//    fun listar(
//        nameTutor: String?,
//        pagination: Pageable
//    ): Page<TutorResponsePaginationDTO> {
//
//        val tutors = if (nameTutor == null) {
//            tutorRepository.findAll(pagination)
//        } else {
//            tutorRepository.findByName(nameTutor, pagination)
//        }
//        return tutors.map {
//            t -> tutorResponsePaginationMapper.map(t)
//        }
//    }
//
//    fun getById(id: Long): TutorResponsePaginationDTO {
//        val possibleTutor = tutorRepository.findById(id).
//                orElseThrow{ NotFoundException(notFoundException) }
//        return tutorResponsePaginationMapper.map(possibleTutor)
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
