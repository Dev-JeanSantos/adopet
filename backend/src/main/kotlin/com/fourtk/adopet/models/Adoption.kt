package com.fourtk.adopet.models

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "tb_adoption")
class Adoption(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var dateAdoption: LocalDateTime = LocalDateTime.now(),

    @OneToOne
    val tutor: Tutor,
    @OneToOne
    val pet: Pet,

    )