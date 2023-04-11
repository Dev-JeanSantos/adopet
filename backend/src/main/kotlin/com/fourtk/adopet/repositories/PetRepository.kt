package com.fourtk.adopet.repositories

import com.fourtk.adopet.models.Pet
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PetRepository: JpaRepository<Pet, Long> {

}
