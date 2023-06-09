package com.fourtk.adopet.controllers

import com.fourtk.adopet.dtos.petrequest.PetRequestDTO
import com.fourtk.adopet.dtos.petresponse.PetResponseDTO
import com.fourtk.adopet.dtos.petresponse.PetResponsePaginationDTO
import com.fourtk.adopet.enums.PetStatus
import com.fourtk.adopet.services.PetService
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

import org.slf4j.LoggerFactory
import javax.validation.Valid

@RestController
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("/pets")
class PetController (
        private val petService: PetService
){

    private val logger = LoggerFactory.getLogger(this::class.java)

    @PostMapping
    fun insertPet(
        @RequestBody @Valid petRequestDTO: PetRequestDTO,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<PetResponseDTO> {
        logger.info("Start insertPet - Controller")
        val petResponseDTO = petService.insertPet(petRequestDTO)
        val uri = uriBuilder.path("/pet/").build().toUri()
        logger.info("End insertPet - Controller")
        return ResponseEntity.created(uri).body(petResponseDTO)
    }

    @GetMapping
    @Transactional
    fun listPets(
        @RequestParam(required = false) petName: String?, @RequestParam(required = false) petCity: String?,
        @PageableDefault(size = 9, sort = ["name"], direction = Sort.Direction.DESC) pagination: Pageable
    ): Page<PetResponsePaginationDTO> {
        logger.info("Start listPets - Controller")
        logger.info("End listPets - Controller")
        return petService.listar(petName,petCity, pagination)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): PetResponseDTO {
        logger.info("Start getPetByID - Controller")
        logger.info("End getPetByID - Controller")
        return petService.getById(id)
    }
    @PutMapping("/{id}")
    @Transactional
    fun updatePet(@PathVariable id: Long, @RequestBody  @Valid petRequestDTO: PetRequestDTO)
            : ResponseEntity<PetResponseDTO>  {
        logger.info("Start updatePet - Controller")
        val petResponseDTO = petService.update(id, petRequestDTO)
        logger.info("End updatePet - Controller")
        return  ResponseEntity.ok().body(petResponseDTO)
    }
    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletePet(@PathVariable id: Long) {
        logger.info("Start deletePet - Controller")
        petService.delete(id)
        logger.info("End deletePet - Controller")
    }

    @PutMapping("/{id}/adopt")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun makeStatusAdopt(@PathVariable id: Long) = petService.updateStatus(id, PetStatus.ADOPTED)

    @PutMapping("/{id}/quarantine")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun makeStatusQuarantine(@PathVariable id: Long) = petService.updateStatus(id, PetStatus.QUARANTINE)
    @PutMapping("/{id}/removed")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun makeStatusRemoved(@PathVariable id: Long) = petService.updateStatus(id, PetStatus.REMOVED)

    @PutMapping("/{id}/suspended")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun makeStatusSuspended(@PathVariable id: Long) = petService.updateStatus(id, PetStatus.SUSPENDED)

    @PutMapping("/{id}/new")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun makeStatusNew(@PathVariable id: Long) = petService.updateStatus(id, PetStatus.NEW)
}