package com.fourtk.adopet.services

import com.fourtk.adopet.dtos.tutorrequest.TutorRequestDTO
import com.fourtk.adopet.dtos.tutorresponse.TutorResponseDTO
import com.fourtk.adopet.dtos.tutorresponse.TutorResponsePaginationDTO
import com.fourtk.adopet.exceptions.NotFoundException
import com.fourtk.adopet.mappers.TutorRequestMapper
import com.fourtk.adopet.mappers.TutorResponseMapper
import com.fourtk.adopet.mappers.TutorResponsePaginationMapper
import com.fourtk.adopet.models.Tutor
import com.fourtk.adopet.repositories.TutorRepository
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class TutorService(
    private val tutorRequestMapper: TutorRequestMapper,
    private val tutorResponseMapper: TutorResponseMapper,
    private val tutorResponsePaginationMapper: TutorResponsePaginationMapper,
    private val tutorRepository: TutorRepository,

    val notFoundException: String = "Tutor not found!"
) : UserDetailsService {

    private val logger = LoggerFactory.getLogger(this::class.java)
    fun insertTutor(tutorRequestDTO: TutorRequestDTO): TutorResponseDTO {
        val tutor = tutorRequestMapper.map(tutorRequestDTO)
        tutorRepository.save(tutor)
        return tutorResponseMapper.map(tutor)
    }

    fun listar(
        nameTutor: String?,
        pagination: Pageable
    ): Page<TutorResponsePaginationDTO> {

        val tutors = nameTutor?.let {
            tutorRepository.findByName(nameTutor, pagination)
        }?:tutorRepository.findAll(pagination)

        return tutors.map { t ->
            tutorResponsePaginationMapper.map(t)
        }
    }

    fun getById(id: Long): TutorResponsePaginationDTO {
        try {
            logger.info("Start getById - Service")
            logger.info("validating if the adoption exists com idAdoption:${id} - Service")
            val possibleTutor = tutorRepository.findById(id).orElseThrow { NotFoundException(notFoundException) }
            logger.info("End getById - Service")
            return tutorResponsePaginationMapper.map(possibleTutor)
        } catch (e: Exception) {
            throw e
        }

    }

    fun update(id: Long, tutorRequestUpdateDTO: TutorRequestDTO): TutorResponseDTO? {
        val tutor = tutorRepository.findById(id).orElseThrow() {
            NotFoundException(notFoundException)
        }
        println(tutor)
        tutor.name = tutorRequestUpdateDTO.name
        tutor.email = tutorRequestUpdateDTO.email
        tutor.cpf = tutorRequestUpdateDTO.cpf
        tutor.address = tutorRequestUpdateDTO.address
        tutor.city = tutorRequestUpdateDTO.city
        tutor.uf = tutorRequestUpdateDTO.uf
        tutor.phone = tutorRequestUpdateDTO.phone
        tutor.password = tutorRequestUpdateDTO.password
        tutor.image = tutorRequestUpdateDTO.image

        return tutorResponseMapper.map(tutor)
    }

    fun delete(id: Long) {
        val tutor = tutorRepository.deleteById(id)
    }

    fun getBYId(idOwner: Long): Tutor {
        try {
            logger.info("Start getById - Service")
            logger.info("validating if the adoption exists com idAdoption:${idOwner} - Service")
            logger.info("End getById - Service")
            return tutorRepository.getOne(idOwner)
        } catch (e: Exception) {
            throw e
        }
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        try {
            logger.info("Start loadUserByUsername - Service")
            logger.info("validating if the adoption exists com idAdoption:${username} - Service")
            val user = tutorRepository.findByEmail(username) ?: throw RuntimeException()
            logger.info("End getById - Service")
            return UserDetail(user)
        } catch (e: Exception) {
            throw e
        }
    }
}
