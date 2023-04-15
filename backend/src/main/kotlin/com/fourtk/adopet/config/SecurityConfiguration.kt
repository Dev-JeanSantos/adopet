package com.fourtk.adopet.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy.STATELESS
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfiguration {
    @Bean
    fun filterChain(httpSecurity: HttpSecurity): SecurityFilterChain {
        httpSecurity.authorizeHttpRequests()
            ?.requestMatchers("/pets")?.hasAuthority("LEITURA_ESCRITA")
            ?.requestMatchers("/tutors")?.permitAll()
            ?.anyRequest()?.authenticated()?.and()?.sessionManagement()
            ?.sessionCreationPolicy(STATELESS)?.and()?.formLogin()?.disable()?.httpBasic()

        return httpSecurity.build()
    }

    @Bean
    fun encoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}