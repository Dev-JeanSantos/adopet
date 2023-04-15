package com.fourtk.adopet.services

import com.fourtk.adopet.models.Tutor
import org.springframework.security.core.userdetails.UserDetails

class UserDetail(private val user: Tutor) : UserDetails {
    override fun getAuthorities() = user.role

    override fun getPassword() = user.password

    override fun getUsername() = user.email

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true

}
