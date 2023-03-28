package com.fourtk.adopet.services

import com.fourtk.adopet.TutorRequestsDTO.TutorRequestDTO
import com.fourtk.adopet.TutorResponsesDTO.TutorResponseDTO
import com.fourtk.adopet.TutorResponsesDTO.TutorResponsePaginationDTO
import com.fourtk.adopet.mappers.TutorRequestMapper
import com.fourtk.adopet.mappers.TutorResponseMapper
import com.fourtk.adopet.mappers.TutorResponsePaginationMapper
import com.fourtk.adopet.repositories.TutorRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import com.fourtk.adopet.exceptions.NotFoundException as NotFoundException

@Service
class TutorService(
    private val tutorRequestMapper: TutorRequestMapper,
    private val tutorResponseMapper: TutorResponseMapper,
    private val tutorResponsePaginationMapper: TutorResponsePaginationMapper,
    private val tutorRepository: TutorRepository,

    val notFoundException: String = "Topic not found!"
) {
    fun insertTutor(tutorRequestDTO: TutorRequestDTO): TutorResponseDTO {
        val tutor = tutorRequestMapper.map(tutorRequestDTO)
        tutorRepository.save(tutor)
        return tutorResponseMapper.map(tutor)
    }

    fun listar(
        nameTutor: String?,
        pagination: Pageable
    ): Page<TutorResponsePaginationDTO> {

        val tutors = if (nameTutor == null) {
            tutorRepository.findAll(pagination)
        } else {
            tutorRepository.findByName(nameTutor, pagination)
        }
        return tutors.map {
            t -> tutorResponsePaginationMapper.map(t)
        }
    }

    fun getById(id: Long): TutorResponsePaginationDTO {
        val possibleTutor = tutorRepository.findById(id).
                orElseThrow{ NotFoundException(notFoundException) }
        return tutorResponsePaginationMapper.map(possibleTutor)

    }
}
