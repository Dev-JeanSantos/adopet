package com.fourtk.adopet.models

import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority

@Entity
data class Role (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String
) : GrantedAuthority {
    override fun getAuthority() =  name
}