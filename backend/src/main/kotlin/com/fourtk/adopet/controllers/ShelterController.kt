package com.fourtk.adopet.controllers

import com.fourtk.adopet.dtos.PetRequestsDTO.ShelterRequestDTO
import com.fourtk.adopet.dtos.ShelterResponseDTO.ResponsibleShelterResponseDTO
import com.fourtk.adopet.dtos.ShelterResponseDTO.ShelterResponseDTO
import com.fourtk.adopet.services.ShelterService
import jakarta.validation.Valid
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/shelters")
class ShelterController (
        private val shelterService: ShelterService
){

    private val logger = LoggerFactory.getLogger(this::class.java)
    @PostMapping
    fun insertPet(
        @RequestBody @Valid shelterRequestDTO: ShelterRequestDTO,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<ShelterResponseDTO> {
        val shelterResponseDTO = shelterService.insertShelter(shelterRequestDTO)
        val uri = uriBuilder.path("/pet/").build().toUri()
        return ResponseEntity.created(uri).body(shelterResponseDTO)
    }

    @GetMapping
    @Transactional
    fun listShelter(
        @RequestParam(required = false) shelterName: String?, @RequestParam(required = false) shelterCity: String?,
        @PageableDefault(size = 5, sort = ["name"], direction = Sort.Direction.DESC) pagination: Pageable
    ): Page<ShelterResponseDTO> {
        return shelterService.listar(shelterCity,shelterName, pagination)
    }

    @GetMapping("relatorio")
    fun relatorio():List<ResponsibleShelterResponseDTO>{
        return shelterService.relatorio()
    }

    @GetMapping("/{idShelter}")
    fun findShelterById(@PathVariable idShelter: Long): ShelterResponseDTO {
        logger.info("Start findShelterByID IdShelter:${idShelter} - Controller")
        logger.info("End findShelterByID - Controller")
        return shelterService.findShelterById(idShelter)
    }


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