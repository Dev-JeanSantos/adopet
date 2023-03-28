package com.fourtk.adopet.controllers

import com.fourtk.adopet.TutorResponsesDTO.TutorResponseDTO
import com.fourtk.adopet.TutorRequestsDTO.TutorRequestDTO
import com.fourtk.adopet.TutorRequestsDTO.TutorRequestUpdateDTO
import com.fourtk.adopet.TutorResponsesDTO.TutorResponsePaginationDTO
import com.fourtk.adopet.services.TutorService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/tutors")
class TutorController (
        private val tutorService: TutorService
){
    @PostMapping
    fun insertTutor(
            @RequestBody @Valid tutorRequestDTO: TutorRequestDTO,
            uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TutorResponseDTO> {
        val tutorResponseDTO = tutorService.insertTutor(tutorRequestDTO)
        val uri = uriBuilder.path("/tutor/").build().toUri()
        return ResponseEntity.created(uri).body(tutorResponseDTO)
    }

    @GetMapping
    @Transactional
    fun listTutors(
        @RequestParam(required = false) nameTutor: String?,
        @PageableDefault(size = 5, sort = ["name"], direction = Sort.Direction.DESC) pagination: Pageable
    ): Page<TutorResponsePaginationDTO> {
        return tutorService.listar(nameTutor, pagination)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): TutorResponsePaginationDTO {
        return tutorService.getById(id)
    }
    @PutMapping("/{id}")
    @Transactional
    fun updateTutor(@PathVariable id: Long,  @Valid tutorRequestDTO: TutorRequestDTO)
            : ResponseEntity<TutorResponseDTO>  {
        val tutorResponseDTO = tutorService.update(id, tutorRequestDTO)
        return  ResponseEntity.ok().body(tutorResponseDTO)
    }
    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteTutor(@PathVariable id: Long) {
        tutorService.delete(id)
    }
}