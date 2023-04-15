package com.fourtk.adopet.repositories

import com.fourtk.adopet.models.Adoption
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AdoptionRepository: JpaRepository<Adoption, Long> {
}
