package com.fourtk.adopet.repositories

import com.fourtk.adopet.models.Pet
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PetRepository: JpaRepository<Pet, Long> {
    fun findByName(petName: String, pagination: Pageable): Page<Pet>
    fun findByTutorCity(petCity: String?, pagination: Pageable): Page<Pet>

}
