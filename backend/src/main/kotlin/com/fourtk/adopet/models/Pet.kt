package com.fourtk.adopet.models

import com.fourtk.adopet.enums.PetCarrying
import com.fourtk.adopet.enums.PetPersonality
import com.fourtk.adopet.enums.PetSpecie
import com.fourtk.adopet.enums.PetStatus
import jakarta.persistence.*
import jakarta.validation.constraints.Email

@Entity
@Table(name = "db_pet")
data class Pet (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        var name: String,
        var idOwner: Long,
        var age: String,
        @Enumerated(EnumType.STRING)
        var status: PetStatus = PetStatus.AVAILABLE,
        @Enumerated(EnumType.STRING)
        var carrying: PetCarrying,
        @Enumerated(EnumType.STRING)
        var specie: PetSpecie,
        @Enumerated(EnumType.STRING)
        var personality: PetPersonality,
        var description: String,
        var image: String?
)



