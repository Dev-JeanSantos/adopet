package com.fourtk.adopet.services

import com.fourtk.adopet.TutorResponsesDTO.TutorResponseDTO
import com.fourtk.adopet.mappers.TutorRequestMapper
import com.fourtk.adopet.mappers.TutorResponseMapper
import com.fourtk.adopet.repositories.TutorRepository
import com.fourtk.adopet.TutorRequestsDTO.TutorRequestDTO
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class TutorService(
    private val tutorRequestMapper: TutorRequestMapper,
    private val tutorResponseMapper: TutorResponseMapper,
    private val tutorRepository: TutorRepository
) {
    fun insertTutor(tutorRequestDTO: TutorRequestDTO): TutorResponseDTO {
        val tutor = tutorRequestMapper.map(tutorRequestDTO)
        tutorRepository.save(tutor)
        return tutorResponseMapper.map(tutor)
    }

    fun listar(
        nameTutor: String?,
        pagination: Pageable
    ): Page<TutorResponseDTO> {

        val tutors = if (nameTutor == null) {
            tutorRepository.findAll(pagination)
        } else {
            tutorRepository.findByName(nameTutor, pagination)
        }
        return tutors.map {
            t -> tutorResponseMapper.map(t)
        }
    }
}
