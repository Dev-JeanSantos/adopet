package com.fourtk.adopet.config

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {

    @Bean
    fun customOpenAPI(): OpenAPI {
        return OpenAPI()
            .components(Components())
            .info(
                Info()
                    .title("ADOPET - SISTEMA DE ADOÇÃO DE PETS")
                    .description("This is the API documentation for the Adopet application - Pet adoption system.")
            )

    }
}