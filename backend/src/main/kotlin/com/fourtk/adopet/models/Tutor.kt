package com.fourtk.adopet.models

import jakarta.persistence.*

@Entity
@Table(name = "db_tutor")
data class Tutor (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        var name: String,
        @Column(nullable = false, unique = true)
        var email: String,
        var password: String,
        @Column(nullable = false, unique = true)
        var cpf: String,
        var address: String,
        var city: String,
        var uf: String,
        var phone: String,
        var image: String?,

        @OneToMany(mappedBy = "tutor")
        val pets: List<Pet> = ArrayList(),

        @OneToMany(mappedBy = "responsible")
        val helters: List<Shelter> = ArrayList(),
)



