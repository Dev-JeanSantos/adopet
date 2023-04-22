package com.fourtk.adopet.config

import com.fourtk.adopet.security.JWTAuthenticationFilter
import com.fourtk.adopet.security.JWTLoginFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfiguration(
    private val userDetailsService: UserDetailsService,
    private val jwtUtil: JWTUtil
)
    : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity?) {
        http?.
        csrf()?.disable()?.
        authorizeRequests()?.
        antMatchers("/tutors")?.hasAuthority("READ_WRITE")?.
        antMatchers("/pets")?.hasAuthority("READ_WRITE")?.
        antMatchers("/shelters")?.hasAuthority("READ_WRITE")?.
        antMatchers("/adoptions")?.hasAuthority("READ_WRITE")?.
        antMatchers(HttpMethod.POST,"/login")?.permitAll()?.
        antMatchers(HttpMethod.GET, "/swagger-ui/*")?.permitAll()?.
        antMatchers(HttpMethod.GET,"/v3/api-docs/**")?.permitAll()?.
        antMatchers("/h2-console/**")?.permitAll()?.
        anyRequest()?.
        authenticated()?.
        and()?.headers()?.frameOptions()?.sameOrigin()?.
        and()
        http?.addFilterBefore(JWTLoginFilter(authManager = authenticationManager(), jwtUtil = jwtUtil), UsernamePasswordAuthenticationFilter().javaClass)
        http?.addFilterBefore(JWTAuthenticationFilter(jwtUtil = jwtUtil), UsernamePasswordAuthenticationFilter().javaClass)
        http?.sessionManagement()?.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    }

    @Bean
    fun bCryptPasswordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth?.userDetailsService(userDetailsService)?.passwordEncoder(bCryptPasswordEncoder())
    }
}