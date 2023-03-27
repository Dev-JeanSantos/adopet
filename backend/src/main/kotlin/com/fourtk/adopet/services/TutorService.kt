package com.fourtk.adopet.services

import com.fourtk.adopet.TutorResponseDTO.TutorResponseDTO
import com.fourtk.adopet.mappers.TutorRequestMapper
import com.fourtk.adopet.mappers.TutorResponseMapper
import com.fourtk.adopet.repositories.TutorRepository
import com.fourtk.adopet.requestDTO.TutorRequestDTO
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

}
