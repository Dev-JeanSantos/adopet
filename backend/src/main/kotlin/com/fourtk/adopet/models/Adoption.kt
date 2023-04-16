package com.fourtk.adopet.models

import java.time.LocalDateTime
import javax.persistence.*

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
    val pet: Pet
)