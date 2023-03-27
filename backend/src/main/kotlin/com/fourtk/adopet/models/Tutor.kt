package com.fourtk.adopet.models

import jakarta.persistence.*

@Entity
@Table(name = "db_tutor")
data class Tutor (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        var name: String,
        var email: String,
        var password: String,
)



