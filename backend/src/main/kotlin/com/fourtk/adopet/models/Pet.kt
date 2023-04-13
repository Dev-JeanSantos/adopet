package com.fourtk.adopet.models

import com.fourtk.adopet.enums.*
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "tb_pet")
data class Pet(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var name: String,
    var age: Int,
    @Enumerated(EnumType.STRING)
    var ageMonthOrYear: PetAgeMonthOrYear,
    @Enumerated(EnumType.STRING)
    var genre: PetGenre,
    @Enumerated(EnumType.STRING)
    var status: PetStatus = PetStatus.AVAILABLE,
    @Enumerated(EnumType.STRING)
    var carrying: PetCarrying,
    @Enumerated(EnumType.STRING)
    var specie: PetSpecie,
    @Enumerated(EnumType.STRING)
    var personality: PetPersonality,
    var description: String,
    var image: String?,
    var dateCreate: LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    var shelter: Shelter? = null,
)



