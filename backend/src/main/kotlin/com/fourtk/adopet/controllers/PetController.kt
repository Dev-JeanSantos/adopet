package com.fourtk.adopet.controllers

import com.fourtk.adopet.dtos.PetRequestsDTO.PetRequestDTO
import com.fourtk.adopet.dtos.PetResponsesDTO.PetResponseDTO
import com.fourtk.adopet.dtos.PetResponsesDTO.PetResponsePaginationDTO
import com.fourtk.adopet.services.PetService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/pets")
class PetController (
        private val petService: PetService
){
    @PostMapping
    fun insertPet(
        @RequestBody @Valid petRequestDTO: PetRequestDTO,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<PetResponseDTO> {
        val petResponseDTO = petService.insertPet(petRequestDTO)
        val uri = uriBuilder.path("/pet/").build().toUri()
        return ResponseEntity.created(uri).body(petResponseDTO)
    }

    @GetMapping
    @Transactional
    fun listPets(
        @RequestParam(required = false) petName: String?, @RequestParam(required = false) petCity: String?,
        @PageableDefault(size = 5, sort = ["name"], direction = Sort.Direction.DESC) pagination: Pageable
    ): Page<PetResponsePaginationDTO> {
        return petService.listar(petName,petCity, pagination)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): PetResponseDTO {
        return petService.getById(id)
    }


//    @PutMapping("/{id}")
//    @Transactional
//    fun updateTutor(@PathVariable id: Long, @RequestBody  @Valid tutorRequestDTO: TutorRequestDTO)
//            : ResponseEntity<TutorResponseDTO>  {
//        val tutorResponseDTO = tutorService.update(id, tutorRequestDTO)
//        return  ResponseEntity.ok().body(tutorResponseDTO)
//    }
//    @DeleteMapping("/{id}")
//    @Transactional
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    fun deleteTutor(@PathVariable id: Long) {
//        tutorService.delete(id)
//    }
}