package com.fourtk.adopet.models

import jakarta.persistence.*

@Entity
@Table(name = "db_shelter")
data class Shelter (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        var name: String,
        var phone: String,
        @Column(nullable = false, unique = true)
        var email: String,
        var address: String,
        var city: String,
        var uf: String,
        var image: String?,

        @ManyToOne
        var responsible: Tutor? = null,

        @OneToMany(mappedBy = "shelter")
        val pets: List<Pet> = ArrayList(),

)



