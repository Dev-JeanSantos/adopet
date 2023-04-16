package com.fourtk.adopet.config

import com.fourtk.adopet.services.TutorService
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import org.springframework.security.core.GrantedAuthority
import java.util.*

@Component
class JWTUtil(
    private val usuarioService: TutorService
) {

    private val expiration : Long = 6000000

    @Value("\${jwt.secret}")
    private lateinit var secret : String

    fun generateToken(username: String, authorities: MutableCollection<out GrantedAuthority>): String? {
        return Jwts.builder()
            .setSubject(username)
            .claim("role", authorities)
            .setExpiration(Date(System.currentTimeMillis() + expiration))
            .signWith(SignatureAlgorithm.HS512, secret.toByteArray())
            .compact()
    }

    fun isValid(jwt: String?): Boolean {
        return try {
            Jwts.parser().setSigningKey(secret.toByteArray()).parseClaimsJws(jwt)
            true
        } catch (e: IllegalArgumentException) {
            throw e
        }
    }

    fun getAuthentication(jwt: String?) : Authentication {
        try {
            val username = Jwts.parser().setSigningKey(secret.toByteArray()).parseClaimsJws(jwt).body.subject
            val user = usuarioService.loadUserByUsername(username)
            return UsernamePasswordAuthenticationToken(username, null, user.authorities)
        }catch (e: Exception) {
            throw e
        }
    }
}