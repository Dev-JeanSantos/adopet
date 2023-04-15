package com.fourtk.adoadoption.controllers

import com.fourtk.adopet.services.AdoptionService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/adoptions")
class AdoptionController (
        private val adoptionService: AdoptionService
){
//
//    private val logger = LoggerFactory.getLogger(this::class.java)
//
//    @PostMapping
//    fun insertAdoption(
//        @RequestBody @Valid adoptionRequestDTO: AdoptionRequestDTO,
//        uriBuilder: UriComponentsBuilder
//    ): ResponseEntity<AdoptionResponseDTO> {
//        logger.info("Start insertAdoption - Controller")
//        val adoptionResponseDTO = adoptionService.insertAdoption(adoptionRequestDTO)
//        val uri = uriBuilder.path("/adoption/").build().toUri()
//        logger.info("End insertAdoption - Controller")
//        return ResponseEntity.created(uri).body(adoptionResponseDTO)
//    }
//
//    @GetMapping
//    @Transactional
//    fun listAdoptions(
//        @RequestParam(required = false) adoptionName: String?, @RequestParam(required = false) adoptionCity: String?,
//        @PageableDefault(size = 5, sort = ["name"], direction = Sort.Direction.DESC) pagination: Pageable
//    ): Page<AdoptionResponsePaginationDTO> {
//        logger.info("Start listAdoptions - Controller")
//        logger.info("End listAdoptions - Controller")
//        return adoptionService.listar(adoptionName,adoptionCity, pagination)
//    }
//
//    @GetMapping("/{id}")
//    fun getById(@PathVariable id: Long): AdoptionResponseDTO {
//        logger.info("Start getAdoptionByID - Controller")
//        logger.info("End getAdoptionByID - Controller")
//        return adoptionService.getById(id)
//    }
//
//    @DeleteMapping("/{id}")
//    @Transactional
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    fun deleteAdoption(@PathVariable id: Long) {
//        logger.info("Start deleteAdoption - Controller")
//        adoptionService.delete(id)
//        logger.info("End deleteAdoption - Controller")
//    }
}