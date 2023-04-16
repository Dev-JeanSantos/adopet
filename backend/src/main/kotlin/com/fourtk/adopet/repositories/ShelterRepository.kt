package com.fourtk.adopet.repositories

import com.fourtk.adopet.dtos.shelterresponse.ResponsibleShelterResponseDTO
import com.fourtk.adopet.models.Shelter
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ShelterRepository: JpaRepository<Shelter, Long> {
    fun findByName(shelterName: String, pagination: Pageable): Page<Shelter>

    fun findByCity(shelterCity: String?, pagination: Pageable): Page<Shelter>
    @Query("SELECT new com.fourtk.adopet.dtos.shelterresponse.ResponsibleShelterResponseDTO (responsible.name, count(s)) FROM Shelter s JOIN s.responsible responsible GROUP BY responsible.name")
    fun report(): List<ResponsibleShelterResponseDTO>
}
