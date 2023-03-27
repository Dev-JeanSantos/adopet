package com.fourtk.adopet.controllers

import com.fourtk.adopet.TutorResponseDTO.TutorResponseDTO
import com.fourtk.adopet.requestDTO.TutorRequestDTO
import com.fourtk.adopet.services.TutorService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
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
        val uri = uriBuilder.path("/tutor/${tutorResponseDTO.id}").build().toUri()
        println(tutorRequestDTO)
        return ResponseEntity.created(uri).body(tutorResponseDTO)
    }
}