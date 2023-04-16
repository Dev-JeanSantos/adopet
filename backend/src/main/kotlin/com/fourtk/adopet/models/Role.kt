package com.fourtk.adopet.models

import org.springframework.security.core.GrantedAuthority
import javax.persistence.*

@Entity

@Table(name = "role")
data class Role (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String
)
    : GrantedAuthority {
    override fun getAuthority() =  name
}