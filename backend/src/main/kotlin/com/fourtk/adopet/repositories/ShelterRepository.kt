package com.fourtk.adopet.repositories

import com.fourtk.adopet.models.Shelter
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ShelterRepository: JpaRepository<Shelter, Long> {

}
