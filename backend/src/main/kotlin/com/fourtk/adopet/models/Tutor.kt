package com.fourtk.adopet.models

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
@Table(name = "tb_tutor")
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

        @OneToMany(mappedBy = "responsible", cascade = [CascadeType.ALL], orphanRemoval = true)
        val helters: List<Shelter>? = ArrayList(),

        @JsonIgnore
        @ManyToMany(fetch = FetchType.EAGER)
        @JoinColumn(name = "user_role")
        val role: List<Role> =  mutableListOf()
)



