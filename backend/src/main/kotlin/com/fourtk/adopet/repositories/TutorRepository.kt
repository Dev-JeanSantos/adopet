package com.fourtk.adopet.repositories

import com.fourtk.adopet.models.Tutor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TutorRepository: JpaRepository<Tutor, Long> {

}
