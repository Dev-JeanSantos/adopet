package com.fourtk.adopet.controllers

import com.fourtk.adopet.dtos.adoptionrequest.AdoptionRequestDTO
import com.fourtk.adopet.dtos.adoptionresponse.AdoptionResponseDTO
import com.fourtk.adopet.services.AdoptionService
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
@RequestMapping("/adoptions")
class AdoptionController(
    private val adoptionService: AdoptionService
) {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @PostMapping
    fun insertAdoption(
        @RequestBody @Valid adoptionRequestDTO: AdoptionRequestDTO,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<AdoptionResponseDTO> {
        logger.info("Start insertAdoption - Controller")
        val adoptionResponseDTO = adoptionService.insertAdoption(adoptionRequestDTO)
        val uri = uriBuilder.path("/adoption/").build().toUri()
        logger.info("End insertAdoption - Controller")
        return ResponseEntity.created(uri).body(adoptionResponseDTO)
//      TODO: Implementar a mudança de status do pet no momento da adoção
    }

    @GetMapping
    @Transactional
    fun listAdoptions(
        @PageableDefault(size = 5, direction = Sort.Direction.DESC)
        pagination: Pageable
    ): Page<AdoptionResponseDTO> {
        logger.info("Start listAdoptions - Controller")
        logger.info("End listAdoptions - Controller")
        return adoptionService.listAllAdoptions(pagination)
    }

    @GetMapping("/{id}")
    fun getAdoptionById(@PathVariable id: Long): AdoptionResponseDTO {
        logger.info("Start getAdoptionByID - Controller")
        logger.info("End getAdoptionByID - Controller")
        return adoptionService.getById(id)
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteAdoption(@PathVariable id: Long) {
        logger.info("Start deleteAdoption - Controller")
        adoptionService.delete(id)
        logger.info("End deleteAdoption - Controller")
    }
}