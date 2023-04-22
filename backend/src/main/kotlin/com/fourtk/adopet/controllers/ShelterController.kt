package com.fourtk.adopet.controllers

import com.fourtk.adopet.dtos.petrequest.ShelterRequestDTO
import com.fourtk.adopet.dtos.shelterresponse.ShelterResponseDTO
import com.fourtk.adopet.services.ShelterService
import com.fourtk.adopet.vo.PetOfShelterVo
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("/shelters")
class ShelterController(
    private val shelterService: ShelterService
) {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @PostMapping
    fun insertShelter(
        @RequestBody @Valid shelterRequestDTO: ShelterRequestDTO,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<ShelterResponseDTO> {
        logger.info("Start insertShelter - Controller")
        val shelterResponseDTO = shelterService.insertShelter(shelterRequestDTO)
        val uri = uriBuilder.path("/pet/").build().toUri()
        logger.info("End insertShelter - Controller")
        return ResponseEntity.created(uri).body(shelterResponseDTO)
    }

    @GetMapping
    @Transactional
    fun listShelter(
        @RequestParam(required = false) shelterName: String?, @RequestParam(required = false) shelterCity: String?,
        @PageableDefault(size = 5, sort = ["name"], direction = Sort.Direction.DESC) pagination: Pageable
    ): Page<ShelterResponseDTO> {
        return shelterService.listar(shelterCity, shelterName, pagination)
//    TODO: Implementar list de abrigos comtodos os pets inclusos (aninhado)
    }

    @GetMapping("reports/totalpetsbyshelter")
    fun getTotalPetsByShelter(): List<PetOfShelterVo> {
        return shelterService.GetTotalPetsByShelter()
    }

    @GetMapping("/{idShelter}")
    fun findShelterById(@PathVariable idShelter: Long): ShelterResponseDTO {
        logger.info("Start findShelterByID IdShelter:${idShelter} - Controller")
        logger.info("End findShelterByID - Controller")
        return shelterService.findShelterById(idShelter)
    }


    @PutMapping("/{idShelter}")
    @Transactional
    fun updateShelter(@PathVariable idShelter: Long, @RequestBody @Valid shelterRequestDTO: ShelterRequestDTO)
            : ResponseEntity<ShelterResponseDTO> {
        logger.info("Start updatePet IdShelter:${idShelter} and new shelter:${shelterRequestDTO} - Controller")
        val shelterResponseDTO = shelterService.update(idShelter, shelterRequestDTO)
        logger.info("End updatePet - Controller")
        return ResponseEntity.ok().body(shelterResponseDTO)
//    TODO: resolver NullPoint associado aos pets
    }

    @DeleteMapping("/{idShelter}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteShelter(@PathVariable idShelter: Long) {
        logger.info("Start deleteShelter IdShelter:${idShelter} - Controller")
        shelterService.delete(idShelter)
        logger.info("End deleteShelter - Controller")
    }
}