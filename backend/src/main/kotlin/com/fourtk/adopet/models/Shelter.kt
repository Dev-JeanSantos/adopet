package com.fourtk.adopet.models

import javax.persistence.*

@Entity
@Table(name = "tb_shelter")
data class Shelter (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        var name: String,
        var cnpj: String,
        var phone: String,
        @Column(nullable = false, unique = true)
        var email: String,
        var address: String,
        var city: String,
        var uf: String,
        var image: String?,

        @ManyToOne
        var responsible: Tutor? = null,

        @OneToMany(mappedBy = "shelter", cascade = [CascadeType.ALL], orphanRemoval = true)
        val pets: List<Pet> = ArrayList(),

)



