package com.fourtk.adopet.controllers

import com.fourtk.adopet.dtos.PetRequestsDTO.ShelterRequestDTO
import com.fourtk.adopet.dtos.PetResponsesDTO.PetResponseDTO
import com.fourtk.adopet.dtos.ShelterResponseDTO.ShelterResponseDTO
import com.fourtk.adopet.services.PetService
import com.fourtk.adopet.services.ShelterService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/shelters")
class ShelterController (
        private val shelterService: ShelterService
){
    @PostMapping
    fun insertPet(
        @RequestBody @Valid shelterRequestDTO: ShelterRequestDTO,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<ShelterResponseDTO> {
        val shelterResponseDTO = shelterService.insertShelter(shelterRequestDTO)
        val uri = uriBuilder.path("/pet/").build().toUri()
        return ResponseEntity.created(uri).body(shelterResponseDTO)
    }

//    @GetMapping
//    @Transactional
//    fun listPets(
//        @RequestParam(required = false) petName: String?, @RequestParam(required = false) petCity: String?,
//        @PageableDefault(size = 5, sort = ["name"], direction = Sort.Direction.DESC) pagination: Pageable
//    ): Page<PetResponsePaginationDTO> {
//        return petService.listar(petName,petCity, pagination)
//    }
//
//    @GetMapping("/{id}")
//    fun getById(@PathVariable id: Long): PetResponseDTO {
//        return petService.getById(id)
//    }
//    @PutMapping("/{id}")
//    @Transactional
//    fun updatePet(@PathVariable id: Long, @RequestBody  @Valid petRequestDTO: PetRequestDTO)
//            : ResponseEntity<PetResponseDTO>  {
//        val petResponseDTO = petService.update(id, petRequestDTO)
//        return  ResponseEntity.ok().body(petResponseDTO)
//    }
//    @DeleteMapping("/{id}")
//    @Transactional
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    fun deletePet(@PathVariable id: Long) {
//        petService.delete(id)
//    }
}