package com.fourtk.adopet.repositories

import com.fourtk.adopet.models.Shelter
import com.fourtk.adopet.vo.PetOfShelterVo
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ShelterRepository : JpaRepository<Shelter, Long> {
    fun findByName(shelterName: String, pagination: Pageable): Page<Shelter>

    fun findByCity(shelterCity: String?, pagination: Pageable): Page<Shelter>
    @Query("SELECT new com.fourtk.adopet.vo.PetOfShelterVo (s.name, s.city, count(p)) FROM Shelter s INNER JOIN s.pets p GROUP BY s.name, s.city")
    fun getTotalPetsByShelter(): List<PetOfShelterVo>
}
